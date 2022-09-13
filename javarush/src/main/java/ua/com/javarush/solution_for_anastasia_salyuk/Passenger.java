package ua.com.javarush.solution_for_anastasia_salyuk;

import lombok.Getter;
import lombok.Setter;

public class Passenger {
    public static final int MAX_AMOUNT_PASSENGERS = 10;
    public static final int RANDOM_AMOUNT_PASSENGERS = Initialization.RANDOM_NUMBER.nextInt(MAX_AMOUNT_PASSENGERS) + 1;
    @Getter
    @Setter
    private int currentFloor;
    @Getter
    @Setter
    private int nextFloor;

    @Override
    public String toString() {
        return "Passenger{" +
                "currentFloor=" + currentFloor +
                ", nextFloor=" + nextFloor +
                '}';
    }
}