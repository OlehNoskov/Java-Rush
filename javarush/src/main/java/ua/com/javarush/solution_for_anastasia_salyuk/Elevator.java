package ua.com.javarush.solution_for_anastasia_salyuk;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    @Getter
    private final int MAX_CAPACITY = 5;
    @Getter
    @Setter
    private int currentMaxFloor;
    @Getter
    @Setter
    private int currentFloor;
    @Getter
    private List<Passenger> listPassengers = new ArrayList<>(MAX_CAPACITY);
}