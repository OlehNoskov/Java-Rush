package ua.com.javarush.restaurant.kitchen;

import ua.com.javarush.restaurant.ConsoleHelper;
import ua.com.javarush.restaurant.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
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
        result += "] of " + tablet;
        return result;
    }
}