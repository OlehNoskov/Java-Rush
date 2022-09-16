package ua.com.javarush.solution_elevator_version_two;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Initialization {
    public static Random RANDOM_NUMBER = new Random();

    public static void initListFloors() {
        for (int i = Building.FIRST_FLOOR; i <= Building.RANDOM_AMOUNT_FLOORS; i++) {
            Floor floor = new Floor(i);
            floor.setListPassengers(getListPassengersOnCurrentFloor(i, Passenger.getRandomAmountPassengers()));
            Building.getInstance().getListFloors().add(floor);
        }
    }

    private static List<Passenger> getListPassengersOnCurrentFloor(int indexFloor, int amountPassengers) {
        List<Passenger> passengerList = new ArrayList<>();
        for (int i = 0; i < amountPassengers; i++) {
            Passenger passenger = new Passenger();
            passenger.setCurrentFloor(indexFloor);
            passenger.setNextFloor(getRandomNextFloorForPassenger(passenger));
            passengerList.add(passenger);
        }
        return passengerList;
    }

    public static int getRandomNextFloorForPassenger(Passenger passenger) {
        int currentNumber = RANDOM_NUMBER.nextInt(Building.FIRST_FLOOR, Building.RANDOM_AMOUNT_FLOORS) + 1;
        return currentNumber != passenger.getCurrentFloor() ? currentNumber : getRandomNextFloorForPassenger(passenger);
    }

    public static List<Integer> getListNextFloors(List<Passenger> passengers) {
        return passengers.stream().map(Passenger::getNextFloor).collect(Collectors.toList());
    }
}