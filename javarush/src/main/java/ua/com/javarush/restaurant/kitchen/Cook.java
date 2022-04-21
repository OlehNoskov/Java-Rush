package ua.com.javarush.restaurant.kitchen;

import ua.com.javarush.restaurant.ConsoleHelper;
import ua.com.javarush.restaurant.Tablet;
import ua.com.javarush.restaurant.statistic.StatisticManager;
import ua.com.javarush.restaurant.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

//Producer - обрабатывает заказы
public class Cook extends Observable implements Runnable {
    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;

    public LinkedBlockingQueue<Order> getQueue() {
        return queue;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public Cook(String name) {
        this.name = name;
    }

    public boolean isBusy() {
        return busy;
    }

    public void startCookingOrder(Order order) {
        this.busy = true;
        Tablet tablet = order.getTablet();

        ConsoleHelper.writeMessage("Start cooking - " + order);

        CookedOrderEventDataRow row = new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes());
        //регистрация события
        StatisticManager.getInstance().register(row);
        try {
            Thread.sleep(order.getTotalCookingTime() * 10L);
        } catch (InterruptedException e) {
            e.getMessage();
        }

        setChanged();
        notifyObservers(order);
        this.busy = false;
    }

    @Override
    public void run() {
        //Проверяет наличие заказов в очереди и отдаем заказы свободным поварам
        try {
            while (true) {
                Thread.sleep(10);
                if (!queue.isEmpty()) {
                    if (!this.isBusy()) {
                        //orderQueue.take - извлечение и удаление элемента из очереди
                        this.startCookingOrder(queue.take());
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toString() {
        return name;
    }
}