package ua.com.javarush.restaurant;

import ua.com.javarush.restaurant.ad.AdvertisementManager;
import ua.com.javarush.restaurant.ad.NoVideoAvailableException;
import ua.com.javarush.restaurant.kitchen.Order;
import ua.com.javarush.restaurant.kitchen.TestOrder;

import java.io.IOException;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    private Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        return getOrder();
    }

    private Order getOrder() {
        Order order = null;
        try {
            order = new Order(this);
            if (order.isEmpty()) {
                return null;
            }
            AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            advertisementManager.processVideos();
            setChanged();
            notifyObservers(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        return order;
    }

    public Order createTestOrder() {
        TestOrder testOrder = null;
        try {
            testOrder = new TestOrder(this);
            if (testOrder.isEmpty()) {
                return null;
            }
            AdvertisementManager advertisementManager = new AdvertisementManager(testOrder.getTotalCookingTime() * 60);
            advertisementManager.processVideos();
            setChanged();
            notifyObservers(testOrder);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + testOrder);
        }
        return testOrder;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}