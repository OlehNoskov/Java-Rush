package ua.com.javarush.solution_for_anastasia_salyuk;

public class Main {
    public static void main(String[] args) {
        Initialization.initListPassengers();
        Initialization.initFloors();

        System.out.println(Initialization.passengerList);
        System.out.println(Initialization.passengerList.size());
        System.out.println("===========================");
        System.out.println(Initialization.floorList);
    }
}