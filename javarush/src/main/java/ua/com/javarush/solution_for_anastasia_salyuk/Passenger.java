package ua.com.javarush.solution_for_anastasia_salyuk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Passenger {
    private final Random random = new Random();
    private final int MAX_AMOUNT_PASSENGERS = 10;
    private final int RANDOM_AMOUNT_PASSENGERS = random.nextInt(MAX_AMOUNT_PASSENGERS) + 1;
    private int currentFloor;
    private int nextFloor;
    private List<Passenger> listPassengers = new ArrayList<>(RANDOM_AMOUNT_PASSENGERS);

    public Passenger(int currentFloor, int nextFloor) {
        this.currentFloor = currentFloor;
        this.nextFloor = nextFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getNextFloor() {
        return nextFloor;
    }

    public void setNextFloor(int nextFloor) {
        this.nextFloor = nextFloor;
    }

    public List<Passenger> getListPassengers() {
        return listPassengers;
    }
}