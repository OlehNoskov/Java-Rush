package ua.com.javarush.solution_elevator;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private static final int MIN_AMOUNT_FLOORS = 5;
    private static final int MAX_AMOUNT_FLOORS = 20;
    public static final int FIRST_FLOOR = 1;
    public static int RANDOM_AMOUNT_FLOORS = Initialization.RANDOM_NUMBER.nextInt(Floor.MIN_AMOUNT_FLOORS, Floor.MAX_AMOUNT_FLOORS) + 1;

    @Getter
    @Setter
    private int numberFloor;
    @Getter
    @Setter
    private List<Passenger> listPassengers = new ArrayList<>();
    @Getter
    @Setter
    private List<Integer> listNextFloorPassenger;

    @Override
    public String toString() {
        return "№" + numberFloor +
                "|          |" +
                "" + listNextFloorPassenger;
    }
}