package ua.com.javarush.restaurant.kitchen;

import ua.com.javarush.restaurant.ConsoleHelper;
import ua.com.javarush.restaurant.Tablet;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
        ConsoleHelper.writeMessage(toString());
        initDishes();
    }

    public int getTotalCookingTime() {
        int totalCookingTime = 0;
        for (Dish dish : dishes) {
            totalCookingTime += dish.getDuration();
        }
        return totalCookingTime;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }

    protected void initDishes(){
        this.dishes = new ArrayList<>();
    }

    @Override
    public String toString() {
        String result = "";
        if (dishes.isEmpty())
            return result;
        result += "Your order: [" + dishes.get(0);

        for (int i = 1; i < dishes.size(); i++) {
            result += ", " + dishes.get(i).name();
        }
        result += "] of " + tablet + ", cooking time " + getTotalCookingTime() + " min";
        return result;
    }
}