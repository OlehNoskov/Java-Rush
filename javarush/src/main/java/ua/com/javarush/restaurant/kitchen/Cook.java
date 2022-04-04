package ua.com.javarush.restaurant.kitchen;

import ua.com.javarush.restaurant.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Cook implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object order) {
        ConsoleHelper.writeMessage("Start cooking " + order);
    }
}