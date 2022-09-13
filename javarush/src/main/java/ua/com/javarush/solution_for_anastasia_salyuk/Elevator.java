package ua.com.javarush.solution_for_anastasia_salyuk;

import java.util.Random;

public class Elevator {
    private final int MIN_AMOUNT_FLOORS = 5;
    private final int MAX_AMOUNT_FLOORS = 20;
    private final Random RANDOM_NUMBER = new Random();
    private final int RANDOM_AMOUNT_FLOORS = RANDOM_NUMBER.nextInt(MIN_AMOUNT_FLOORS, MAX_AMOUNT_FLOORS) + 1;
    private int currentMaxFloor;

//    public static int getCurrentMaxFloor() {
//        return currentMaxFloor;
//    }
//
//    public static void setCurrentMaxFloor(int currentMaxFloor) {
//        Elevator.currentMaxFloor = currentMaxFloor;
//    }
}