package ua.com.javarush.solution_elevator.models;

import ua.com.javarush.solution_elevator.intergaces.ElevatorInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Building {
    public static final int MIN_AMOUNT_FLOORS = 5;
    public static final int MAX_AMOUNT_FLOORS = 20;
    private int floors;
    private ElevatorInterface elevator;
    private List<Integer>[] passengersOnFloor;
    private static Random random = new Random();
    private static final int STEPS_TO_VIEW = 100;


    public Building(int floors) {
        this.floors = floors;
        elevator = new Elevator(floors);
        passengersOnFloor = new List[floors];
        fillRandomPassengers();
    }

    /**
     * This method shows how the elevator work
     **/

    public void run() {
        for (int i = 1; i <= STEPS_TO_VIEW; i++) {
            int removedPassengers = this.removePassengersFromLift();
            if (elevator.isEmpty()) //if elevator is empty, recalculate direction
                elevator.setDirection(this.getElevatorDirectionByMajorPartOfPeople());

            int addedPassengers = this.addPassengersToElevator();

            if (removedPassengers == 0 && addedPassengers == 0) i--;
            else {
                createRandomPassengers(removedPassengers); // recreate passengers who leave the elevator
                this.showInformation(i);
            }
            elevator.move();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Something wrong!!!");
            }
        }
    }

    private int addPassengersToElevator() {
        elevator.correctDirection();

        ArrayList<Integer> indexesToDelete = new ArrayList<>();
        for (int i = 0; i < passengersOnFloor[elevator.getCurrentFloor() - 1].size() && !elevator.isFull(); i++) {
            if (elevator.isDirection()) { //if lift goes up
                if (passengersOnFloor[elevator.getCurrentFloor() - 1].get(i) > elevator.getCurrentFloor()) {
                    indexesToDelete.add(i);
                    elevator.addPassenger(
                            passengersOnFloor[elevator.getCurrentFloor() - 1].get(i));
                }
            } else {
                if (passengersOnFloor[elevator.getCurrentFloor() - 1].get(i) < elevator.getCurrentFloor()) {
                    indexesToDelete.add(i);
                    elevator.addPassenger(
                            passengersOnFloor[elevator.getCurrentFloor() - 1].get(i));
                }
            }
        }
        if (indexesToDelete.size() > 0) {
            passengersOnFloor[elevator.getCurrentFloor() - 1].subList(0, indexesToDelete.size()).clear();
        }
        return indexesToDelete.size();
    }

    private int removePassengersFromLift() {
        return elevator.removePassengers();
    }

    private void fillRandomPassengers() {
        for (int i = 0; i < floors; i++) {
            passengersOnFloor[i] = fillFloor(i + 1);
        }
    }

    private List<Integer> fillFloor(int currentFloor) {
        ArrayList<Integer> floor = new ArrayList<>();
        int passInTheFloor = random.nextInt(Elevator.MAX_PASSENGERS + 1);
        for (int j = 1; j < passInTheFloor; j++) {
            floor.add(createRandomPassenger(currentFloor));
        }
        return floor;
    }

    private int createRandomPassenger(int currentFloor) {
        int passengerTargetFloor = currentFloor;
        while (passengerTargetFloor == currentFloor)
            passengerTargetFloor = random.nextInt(floors) + 1;

        return passengerTargetFloor;
    }

    private void createRandomPassengers(int count) {
        for (int j = 0; j < count; j++)
            this.passengersOnFloor[elevator.getCurrentFloor() - 1].add(
                    createRandomPassenger(elevator.getCurrentFloor()));
    }

    private boolean getElevatorDirectionByMajorPartOfPeople() {
        if (elevator.getCurrentFloor() == 1) return true;
        else if (elevator.getCurrentFloor() == floors) return false;
        else {
            int peoplesWhoWantUp = 0;
            for (int i = 0; i < passengersOnFloor[elevator.getCurrentFloor() - 1].size(); i++)
                if (passengersOnFloor[elevator.getCurrentFloor() - 1].get(i) > elevator.getCurrentFloor())
                    peoplesWhoWantUp++;

            return passengersOnFloor[elevator.getCurrentFloor() - 1].size() - peoplesWhoWantUp < peoplesWhoWantUp;
        }
    }

    private void showInformation(int step) {
        System.out.println("===== Step " + step + " =====");
        System.out.println(this);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = floors - 1; i >= 0; i--) {
            if (elevator.getCurrentFloor() != i + 1)
                result.append(" Floor № ").append(i + 1).append(passengersOnFloor[i].toString()).append("\n");
            else
                result.append(" Floor № ").append(i + 1).append(passengersOnFloor[i].toString()).append(" Elevator: [").append(elevator).append("]").append("\n");
        }
        return result.toString();
    }
}