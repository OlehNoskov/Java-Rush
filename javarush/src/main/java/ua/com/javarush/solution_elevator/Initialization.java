package ua.com.javarush.solution_elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Initialization {
    public static Random RANDOM_NUMBER = new Random();

    public static List<Floor> getInitListFloors() {
        List<Floor> listFloors = new ArrayList<>();
        int amountPassengersOnCurrentFloor = Passenger.getRandomAmountPassengers();
        for (int i = Floor.FIRST_FLOOR; i <= Floor.RANDOM_AMOUNT_FLOORS; i++) {
            Floor floor = new Floor();
            floor.setNumberFloor(i);
            floor.setListPassengers(getListPassengersOnCurrentFloor(i, amountPassengersOnCurrentFloor));
            floor.setListNextFloorPassenger(getListNextFloors(floor.getListPassengers()));
            listFloors.add(floor);
        }
        return listFloors;
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

    private static int getRandomNextFloorForPassenger(Passenger passenger) {
        int currentNumber = RANDOM_NUMBER.nextInt(Floor.FIRST_FLOOR, Floor.RANDOM_AMOUNT_FLOORS) + 1;
        return currentNumber != passenger.getCurrentFloor() ? currentNumber : getRandomNextFloorForPassenger(passenger);
    }

    private static List<Integer> getListNextFloors(List<Passenger> passengers) {
        return passengers.stream().map(Passenger::getNextFloor).collect(Collectors.toList());
    }
}