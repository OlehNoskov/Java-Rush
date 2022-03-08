package ua.com.javarush.multithreading.big_task_refactoring.car;

public class Sedan extends Car {

    protected Sedan(int numberOfPassengers) {
        super(SEDAN, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed(){
        return 120;
    }
}