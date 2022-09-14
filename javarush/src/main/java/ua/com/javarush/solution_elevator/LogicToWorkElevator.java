package ua.com.javarush.solution_elevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LogicToWorkElevator {
    private static Elevator elevator = Elevator.getInstance();

    public static void run() {
    }

    public static void startFromFirstFloorToUP() throws InterruptedException {
        Initialization.initListFloors();
        System.out.println("=== Step 1 ===");
        System.out.println("^^^ Elevator with passengers on the floor №1 ^^^" + "\n");

        show();
        addPassengersToElevatorFirstFloor(Initialization.listFloors.get(0));
        removePassengersFromFloor(Initialization.listFloors.get(0), elevator.getListPassengers());
        int maxFloor = getCurrentMaxFloor();
        int stepCount = 2;

        Thread.sleep(500);

        for (int i = 1; i < maxFloor; i++) {
            System.out.println("=== Step " + stepCount + " ===");
            System.out.println("^^^ Elevator with passengers on the floor №" + stepCount + " ^^^" + "\n");
            elevator.setCurrentFloor(stepCount);

            Initialization.listFloors.get(i).setListNumbersNextFloors(elevator.getListPassengers().stream()
                    .map(Passenger::getNextFloor).toList());

            removePassengersFromElevator(Initialization.listFloors.get(i));
            addPassengersToElevatorUp(Initialization.listFloors.get(i));

            if (!elevator.getListPassengers().isEmpty()) {
                maxFloor = getCurrentMaxFloor();
            }

            if (elevator.getCurrentFloor() == maxFloor) {
                Initialization.listFloors.get(i).setListNumbersNextFloors(Collections.emptyList());
                System.out.println("It's upper floor!!!");


            }

            show();
            stepCount++;
            Initialization.listFloors.get(i).setListNumbersNextFloors(Collections.emptyList());

            Thread.sleep(500);
        }
    }

    private static void show() {
        for (int i = Initialization.listFloors.size() - 1; i >= 0; i--) {
            System.out.println(Initialization.listFloors.get(i));
        }
        System.out.println();
    }

    private static void addPassengersToElevatorFirstFloor(Floor firstFloor) {
        for (Passenger passenger : firstFloor.getListPassengers()) {
            if (elevator.getListPassengers().size() != Elevator.MAX_CAPACITY) {
                elevator.getListPassengers().add(passenger);
            }
        }
    }

    private static void removePassengersFromFloor(Floor floor, List<Passenger> passengers) {
        floor.getListPassengers().removeAll(passengers);
    }

    private static void addPassengersToElevatorUp(Floor currentFloor) {
        List<Passenger> passengersForRemove = new ArrayList<>();

        for (Passenger passenger : currentFloor.getListPassengers()) {
            if (elevator.getListPassengers().size() < Elevator.MAX_CAPACITY
                    && passenger.getNextFloor() > elevator.getCurrentFloor()) {
                elevator.getListPassengers().add(passenger);
                passengersForRemove.add(passenger);
            }
        }
        removePassengersFromFloor(currentFloor, passengersForRemove);
    }

    private static void removePassengersFromElevator(Floor currentFloor) {
        List<Passenger> listAddToFloor = elevator.getListPassengers().stream()
                .filter(passenger -> passenger.getNextFloor() == currentFloor.getNumberFloor())
                .collect(Collectors.toList());
        elevator.getListPassengers().removeIf(passenger -> passenger.getNextFloor() == currentFloor.getNumberFloor());

        addPassengersToFloorFromElevator(currentFloor, listAddToFloor);
    }

    private static int getCurrentMaxFloor() {
        return elevator.getListPassengers().stream().map(Passenger::getNextFloor).toList().stream().max(Integer::compare).get();
    }

    private static void addPassengersToFloorFromElevator(Floor floor, List<Passenger> passengers) {
        for (Passenger passenger : passengers) {
            passenger.setCurrentFloor(floor.getNumberFloor());
            passenger.setNextFloor(Initialization.getRandomNextFloorForPassenger(passenger));
            floor.getListPassengers().add(passenger);
        }
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