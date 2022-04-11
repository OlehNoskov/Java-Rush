package ua.com.javarush.restaurant;


import ua.com.javarush.restaurant.kitchen.Cook;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Oleg");
        tablet.addObserver(cook);

        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();

        DirectorTablet directorTablet = new DirectorTablet();

        directorTablet.printAdvertisementProfit();
        directorTablet.printCookingWorkLoading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}