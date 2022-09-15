package ua.com.javarush.solution_elevator;

import java.util.ArrayList;
import java.util.List;

public class LogicToWorkElevator {
    //true - up, false - down
    private static boolean direction = true;
    private static int maxFloor = 1;
    private static int currentFloor = 1;
    private static int countStep = 1;

    public static void test() {
        Initialization.initListFloors();
        Elevator.getInstance().setCurrentFloor(currentFloor);
        while (true) {
            if (direction) {
                System.out.println("=== Step " + countStep + " ===");
                System.out.println(Building.getInstance().toString());
                removePassengerFromElevator();
                addPassengerToElevator();

                currentFloor++;
                maxFloor = getCurrentMaxFloor();
                countStep++;
                Elevator.getInstance().setCurrentFloor(currentFloor);

                if (currentFloor == maxFloor) {
                    System.out.println("=== Step " + countStep + " ===");
                    System.out.println("It's upper Floor!!!");
                    // search direction : UP or DOWN
                    if (whereMoveUpOrDown(Initialization.getListNextFloors(Building.getInstance()
                            .getListFloors().get(currentFloor - 1).getListPassengers()), currentFloor) == 0) {
                        continue;
                    }
                    removePassengerFromElevator();
                    System.out.println(Building.getInstance().toString());
                    direction = false;
                }
            }
            if (!direction) {
                break;
            }
        }
    }

    private static void removePassengerFromElevator() {
        List<Passenger> removePassengerFromElevator = new ArrayList<>();
        if (!Elevator.getInstance().getListPassengers().isEmpty()) {
            for (Passenger passenger : Elevator.getInstance().getListPassengers()) {
                if (passenger.getNextFloor() == currentFloor) {
                    Elevator.getInstance().getListPassengers().remove(passenger);
                    // set next Random number floor
                    passenger.setNextFloor(Initialization.getRandomNextFloorForPassenger(passenger));
                    removePassengerFromElevator.add(passenger);
                }
            }
            addPassengerToFloor(removePassengerFromElevator);
        }
    }

    private static void addPassengerToElevator() {
        List<Passenger> passengersForRemove = new ArrayList<>();
        // add passengers to elevator when moves UP
        if (direction) {
            for (Passenger passenger : Building.getInstance().getListFloors().get(currentFloor - 1).getListPassengers()) {
                if (Elevator.getInstance().getListPassengers().size() < Elevator.MAX_CAPACITY
                        && passenger.getNextFloor() > currentFloor) {
                    Elevator.getInstance().getListPassengers().add(passenger);
                    passengersForRemove.add(passenger);
                }
            }
            // add passengers to elevator when moves DOWN
        } else {
            for (Passenger passenger : Building.getInstance().getListFloors().get(currentFloor - 1).getListPassengers()) {
                if (Elevator.getInstance().getListPassengers().size() < Elevator.MAX_CAPACITY
                        && passenger.getNextFloor() < currentFloor) {
                    Elevator.getInstance().getListPassengers().add(passenger);
                    passengersForRemove.add(passenger);
                }
            }
        }
        removePassengerToFloor(passengersForRemove);
    }

    private static void addPassengerToFloor(List<Passenger> passengers) {
        Building.getInstance().getListFloors().get(currentFloor - 1).getListPassengers().addAll(passengers);
    }

    private static void removePassengerToFloor(List<Passenger> passengers) {
        Building.getInstance().getListFloors().get(currentFloor - 1).getListPassengers().removeAll(passengers);
    }

    private static int getCurrentMaxFloor() {
        return Elevator.getInstance().getListPassengers().stream().map(Passenger::getNextFloor).toList().stream().max(Integer::compare).get();
    }

    private static int getCurrentMinFloor() {
        return Elevator.getInstance().getListPassengers().stream().map(Passenger::getNextFloor).toList().stream().min(Integer::compare).get();
    }

    private static int whereMoveUpOrDown(List<Integer> numberFloors, int currentMaxFloor) {
        int countUp = 0;
        int countDown = 0;
        for (Integer integer : numberFloors) {
            if (integer > currentMaxFloor) {
                countUp++;
            } else {
                countDown++;
            }
        }
        return countUp >= countDown ? 0 : 1;
    }
}