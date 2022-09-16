package ua.com.javarush.solution_elevator_version_two;

import lombok.Getter;
import lombok.Setter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Elevator {
    private static Elevator instance = null;
    public static final int MAX_CAPACITY = 5;
    @Getter
    @Setter
    private int currentMaxFloor;
    @Getter
    @Setter
    private int currentFloor;
    @Setter
    @Getter
    private Queue<Passenger> listPassengers = new ConcurrentLinkedDeque<>();

    private Elevator() {
    }

    public static Elevator getInstance() {
        if (instance == null) {
            instance = new Elevator();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "-> Elevator: " + listPassengers;
    }
}