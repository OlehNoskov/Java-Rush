package ua.com.javarush.solution_for_anastasia_salyuk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Initialization {
    public static Random RANDOM_NUMBER = new Random();
    public static List<Passenger> passengerList = new ArrayList<>();
    public static List<Floor> floorList = new ArrayList<>();
    private static int currentFloor;
    private static int nextFloor;

    public static void initListPassengers() {
        for (int i = 0; i < Passenger.RANDOM_AMOUNT_PASSENGERS; i++) {
            Passenger passenger = new Passenger();
            currentFloor = RANDOM_NUMBER.nextInt(Floor.FIRST_FLOOR, Floor.RANDOM_AMOUNT_FLOORS) + 1;
            passenger.setCurrentFloor(currentFloor);

            nextFloor = RANDOM_NUMBER.nextInt(Floor.FIRST_FLOOR, Floor.RANDOM_AMOUNT_FLOORS) + 1;
            passenger.setNextFloor(getRandomNextFloorForPassenger(passenger));
            passengerList.add(passenger);
        }
    }

    public static void initFloors() {
        for (int i = 1; i <= Floor.RANDOM_AMOUNT_FLOORS; i++) {
            Floor floor = new Floor();
            floor.setNumberFloor(i);
            addPassengersOnFloor(floor);
            floor.setListWaitingPassengers(listWaitingPassengers(floor));
            floorList.add(floor);
        }
    }

    private static void addPassengersOnFloor(Floor floor) {
        floor.setListPassengers(passengerList.stream()
                .filter(p -> p.getCurrentFloor() == floor.getNumberFloor())
                .collect(Collectors.toList()));
    }

    private static int getRandomNextFloorForPassenger(Passenger passenger) {
        int currentNumber = RANDOM_NUMBER.nextInt(Floor.FIRST_FLOOR, Floor.RANDOM_AMOUNT_FLOORS) + 1;
        return currentNumber != passenger.getCurrentFloor() ? currentNumber : getRandomNextFloorForPassenger(passenger);
    }

    private static List<Integer> listWaitingPassengers(Floor floor) {
        return passengerList.stream().filter(p-> p.getCurrentFloor() == floor.getNumberFloor())
                .map(Passenger::getNextFloor).collect(Collectors.toList());
    }
}