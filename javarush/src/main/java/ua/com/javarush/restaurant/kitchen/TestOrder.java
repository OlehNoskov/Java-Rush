package ua.com.javarush.restaurant.kitchen;

import ua.com.javarush.restaurant.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    public void initDishes() {
        this.dishes = new ArrayList<>();

        //генерация случайных блюд
        Dish[] values = Dish.values();
        int countDishes = (int) (Math.random() * 3 + 2);
        for (int i = 0; i < countDishes; i++) {
            int dishIndex = (int) (Math.random() * values.length);
            dishes.add(values[dishIndex]);
        }
    }
}