package ua.com.javarush.solution_for_anastasia_salyuk;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Initialization {
    public static Random RANDOM_NUMBER = new Random();
    @Getter
    public List<Passenger> passengerList = new ArrayList<>();
    @Getter
    public List<Floor> floorList = new ArrayList<>();
    private static int currentFloor;
    private static int nextFloor;

    public void initListPassengers() {
        for (int i = 0; i < Passenger.RANDOM_AMOUNT_PASSENGERS; i++) {
            Passenger passenger = new Passenger();
            currentFloor = RANDOM_NUMBER.nextInt(Floor.FIRST_FLOOR, Floor.RANDOM_AMOUNT_FLOORS) + 1;
            passenger.setCurrentFloor(currentFloor);

            nextFloor = RANDOM_NUMBER.nextInt(Floor.FIRST_FLOOR, Floor.RANDOM_AMOUNT_FLOORS) + 1;
//            if (currentFloor != nextFloor) {
            passenger.setNextFloor(nextFloor);
//            }
            passengerList.add(passenger);
        }
    }

    public void initFloors() {
        for (int i = 1; i <= Floor.RANDOM_AMOUNT_FLOORS; i++) {
            Floor floor = new Floor();
            floor.setNumberFloor(i);
            addPassengers(floor);
            floorList.add(floor);
        }
    }

    private void addPassengers(Floor floor) {
        List<Passenger> passengersOnFloors = new ArrayList<>();
        for (Passenger passenger : passengerList) {
            if (passenger.getCurrentFloor() == floor.getNumberFloor()) {
                passengersOnFloors.add(passenger);
            }
        }
        floor.setListPassengers(passengersOnFloors);
    }
}