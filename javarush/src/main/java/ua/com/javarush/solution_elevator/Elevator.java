package ua.com.javarush.solution_elevator;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private static Elevator instance = null;
    public static final int MAX_CAPACITY = 5;
    @Getter
    @Setter
    private int currentMaxFloor;
    @Getter
    @Setter
    private int currentFloor;
    public static List<Passenger> listPassengers = new ArrayList<>(MAX_CAPACITY);

    private Elevator() {
    }

    public static Elevator getInstance() {
        if (instance == null) {
            instance = new Elevator();
        }
        return instance;
    }
}