package ua.com.javarush.solution_elevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LogicToWorkElevator {
    private static Elevator elevator = Elevator.getInstance();

    public static void run() {

    }

    public static void startFromFirstFloorToUP() {
        Initialization.initListFloors();
        addPassengersToElevatorFirstFloor(Initialization.listFloors.get(0));
        show();
//        System.out.println(elevator.getListPassengers());
        int maxFloor = getCurrentMaxFloor();
        int stepCount = 2;
        System.out.println("Elevator add Passengers from first floor!");

        for (Passenger passenger: elevator.getListPassengers()){
            System.out.println(passenger);
        }

        for (int i = 1; i < maxFloor; i++) {
            System.out.println("=== Step " + stepCount + " ===");
            removePassengersFromElevator(Initialization.listFloors.get(i));
            addPassengersToElevatorUp(Initialization.listFloors.get(i));
            if (!elevator.getListPassengers().isEmpty()) {
                maxFloor = getCurrentMaxFloor();
            }
            else {
                System.out.println("Lift is UP!");
            }
            show();
            System.out.println("Elevator passengers ont the floor #" + stepCount + "\n");
            for (Passenger passenger: elevator.getListPassengers()){
                System.out.println(passenger);
            }
            elevator.setCurrentFloor(stepCount);
            System.out.println(elevator.getCurrentFloor());
            stepCount++;
        }
    }

    private static void show() {
        for (int i = Initialization.listFloors.size() - 1; i >= 0; i--) {
            System.out.println(Initialization.listFloors.get(i));
        }
    }

    private static void addPassengersToElevatorFirstFloor(Floor firstFloor) {
        for (Passenger passenger : firstFloor.getListPassengers()) {
            if (elevator.getListPassengers().size() != Elevator.MAX_CAPACITY) {
                elevator.getListPassengers().add(passenger);
            }
        }
    }

    private static void addPassengersToElevatorUp(Floor currentFloor) {
        List<Passenger> passengersToRemove = new ArrayList<>();

        for (Passenger passenger : currentFloor.getListPassengers()) {
            if (elevator.getListPassengers().size() != Elevator.MAX_CAPACITY
                    && passenger.getNextFloor() > elevator.getCurrentFloor()) {
                elevator.getListPassengers().add(passenger);
                passengersToRemove.add(passenger);
            }
            else {
                System.out.println("No passengers!");
            }
        }
        removePassengersFromFloor(currentFloor, passengersToRemove);
        currentFloor.setListNextFloorPassenger(Initialization.getListNextFloors(currentFloor.getListPassengers()));
    }

//    private static void addPassengersToElevatorDown(Floor currentFloor) {
//        for (Passenger passenger : currentFloor.getListPassengers()) {
//            if (elevator.getListPassengers().size() != Elevator.MAX_CAPACITY && passenger.getNextFloor() < elevator.getCurrentFloor()) {
//                elevator.getListPassengers().add(passenger);
//            }
//        }
//    }

    private static void removePassengersFromElevator(Floor currentFloor) {
        elevator.getListPassengers().removeIf(passenger -> passenger.getNextFloor() == currentFloor.getNumberFloor());
    }

    private static int getCurrentMaxFloor() {
        return elevator.getListPassengers().stream().map(Passenger::getNextFloor).toList().stream().max(Integer::compare).get();
    }

    private static void removePassengersFromFloor(Floor floor, List<Passenger> passengers) {
        floor.getListPassengers().remove(passengers);
    }
}