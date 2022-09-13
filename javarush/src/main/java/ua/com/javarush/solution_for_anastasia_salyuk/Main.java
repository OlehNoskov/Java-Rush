package ua.com.javarush.solution_for_anastasia_salyuk;

public class Main {
    public static void main(String[] args) {
        Initialization initialization = new Initialization();
        initialization.initListPassengers();
        System.out.println(initialization.getPassengerList());
        System.out.println("===========================");
        initialization.initFloors();
        System.out.println(initialization.floorList);
    }
}