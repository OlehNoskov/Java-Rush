package ua.com.javarush.other.save_time;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 10; i++) {
                System.out.format("Элемент 'ShareItem - " + i + " добавлен' " + "\n");
                queue.offer(new ShareItem("ShareItem - " + i, i));
                Thread.sleep(100);
                if (queue.hasWaitingConsumer()) {
                    System.out.format("Consumer в ожидании!" +"\n");
                }
            }
        } catch (InterruptedException e) {

        }
    }
}