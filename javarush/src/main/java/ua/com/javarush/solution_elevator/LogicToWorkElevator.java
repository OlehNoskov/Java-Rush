package ua.com.javarush.solution_elevator;

import java.util.ArrayList;
import java.util.List;

public class LogicToWorkElevator {
    //true - up, false - down
    private static boolean direction = true;
    private static int maxFloor = 1;
    private static int minFloor = 1;
    private static int currentFloor = 1;
    private static int countStep = 1;

    public static void run() throws InterruptedException {
        Initialization.initListFloors();
        Elevator.getInstance().setCurrentFloor(currentFloor);
        while (true) {
            System.out.println("=== Step " + countStep + " ===");
            countStep++;
            // Elevator UP
            if (direction) {
                System.out.println(Building.getInstance().toString());
                removePassengerFromElevator();
                addPassengerToElevator();

                currentFloor++;
                maxFloor = getCurrentMaxFloor();
                Elevator.getInstance().setCurrentFloor(currentFloor);

                if (currentFloor == maxFloor) {
                    System.out.println("MAX FLOOR!!!");
                    removePassengerFromElevator();
                    // search direction among passengers on upper floor: UP or DOWN, Elevator at the moment is empty.
                    if (whereMoveUpOrDown(Initialization.getListNextFloors(Building.getInstance()
                            .getListFloors().get(currentFloor - 1).getListPassengers()), currentFloor) == 1) {

//                        removePassengerFromElevator();
                        addPassengerToElevator();
                        System.out.println("=== Step " + countStep + " ===");
                        System.out.println(Building.getInstance().toString());
                        direction = false;
                        countStep++;
                        maxFloor = 1;
                    }
                }
                // Elevator DOWN
            } else {
                Elevator.getInstance().setCurrentFloor(currentFloor);
                removePassengerFromElevator();
                addPassengerToElevator();
                System.out.println(Building.getInstance().toString());
                currentFloor--;
                minFloor = getCurrentMinFloor();

                if (currentFloor == minFloor) {
                    removePassengerFromElevator();
                    direction = true;
                    minFloor = 1;
                }
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
                    passenger.setCurrentFloor(currentFloor);
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
        if (Elevator.getInstance().getListPassengers().isEmpty()) {
            System.out.println("List is empty!");
        }
        return Elevator.getInstance().getListPassengers().size() == 1 ? Elevator.getInstance().getListPassengers().element().getNextFloor() :
                Elevator.getInstance().getListPassengers().stream().map(Passenger::getNextFloor).toList().stream().max(Integer::compare).get();
    }

    private static int getCurrentMinFloor() {
        if (Elevator.getInstance().getListPassengers().isEmpty()) {
            System.out.println("List is empty!");
        }
        return Elevator.getInstance().getListPassengers().size() == 1 ? Elevator.getInstance().getListPassengers().element().getNextFloor() :
                Elevator.getInstance().getListPassengers().stream().map(Passenger::getNextFloor).toList().stream().min(Integer::compare).get();
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