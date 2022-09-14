package ua.com.javarush.solution_elevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Initialization {
    public static Random RANDOM_NUMBER = new Random();
    public static List<Floor> listFloors = new LinkedList<>();

    public static void initListFloors() {
        int amountPassengersOnCurrentFloor;
        for (int i = Floor.FIRST_FLOOR; i <= Floor.RANDOM_AMOUNT_FLOORS; i++) {
            amountPassengersOnCurrentFloor = Passenger.getRandomAmountPassengers();
            Floor floor = new Floor();
            floor.setNumberFloor(i);
            floor.setListPassengers(getListPassengersOnCurrentFloor(i, amountPassengersOnCurrentFloor));
            listFloors.add(floor);
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

    public static List<Integer> getListNextFloors(List<Passenger> passengers) {
        return passengers.stream().map(Passenger::getNextFloor).collect(Collectors.toList());
    }

    public static int getRandomNextFloorForPassenger(Passenger passenger) {
        int currentNumber = RANDOM_NUMBER.nextInt(Floor.FIRST_FLOOR, Floor.RANDOM_AMOUNT_FLOORS) + 1;
        return currentNumber != passenger.getCurrentFloor() ? currentNumber : getRandomNextFloorForPassenger(passenger);
    }

    public static void restartData(){
        listFloors = new LinkedList<>();
    }
}