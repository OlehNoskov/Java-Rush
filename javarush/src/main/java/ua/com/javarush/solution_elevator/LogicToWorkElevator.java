package ua.com.javarush.solution_elevator;

import java.util.List;
import java.util.stream.Collectors;

public class LogicToWorkElevator {
    private static Elevator elevator = Elevator.getInstance();

    public static void run() {

    }

    public static void startFromFirstFloorToUP() {
        Initialization.initListFloors();
        addPassengersToElevator(Initialization.listFloors.get(0));
        show();
        System.out.println(Elevator.listPassengers);
        System.out.println(getCurrentMaxFloor());
    }

    private static void show() {
        for (int i = Initialization.listFloors.size() - 1; i >= 0; i--) {
            System.out.println(Initialization.listFloors.get(i));
        }
    }

    private static void addPassengersToElevator(Floor currentFloor) {
        for (Passenger passenger : currentFloor.getListPassengers()) {
            Elevator.listPassengers.add(passenger);
            if (Elevator.listPassengers.size() == Elevator.MAX_CAPACITY) {
                break;
            }
        }
    }

    private static void removePassengersFromElevator(Floor currentFloor) {
        Elevator.listPassengers.removeIf(passenger -> passenger.getNextFloor() == currentFloor.getNumberFloor());
    }

    private static int getCurrentMaxFloor() {
        return Elevator.listPassengers.stream().map(Passenger::getNextFloor).toList().stream().max(Integer::compare).get();
    }
}