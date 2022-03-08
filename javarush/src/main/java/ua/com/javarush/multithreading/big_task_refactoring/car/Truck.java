package ua.com.javarush.multithreading.big_task_refactoring.car;

public class Truck extends Car{

    public Truck(int numberOfPassengers) {
        super(TRUCK, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed(){
        return 80;
    }
}