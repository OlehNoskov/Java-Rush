package ua.com.javarush.solution_elevator;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

public class Passenger {
    private static final int MAX_AMOUNT_PASSENGERS = 5;
    @Getter
    @Setter
    private int currentFloor;
    @Getter
    @Setter
    private int nextFloor;

    public static int getRandomAmountPassengers() {
        return new Random().nextInt(MAX_AMOUNT_PASSENGERS) + 1;
    }
}