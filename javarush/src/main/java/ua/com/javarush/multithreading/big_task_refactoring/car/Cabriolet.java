package ua.com.javarush.multithreading.big_task_refactoring.car;

public class Cabriolet extends Car {
    public Cabriolet(int numberOfPassengers) {
        super(CABRIOLET, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed(){
        return 90;
    }
}