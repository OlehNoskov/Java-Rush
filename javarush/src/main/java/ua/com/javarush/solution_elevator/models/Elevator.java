package ua.com.javarush.solution_elevator.models;

import ua.com.javarush.solution_elevator.intergaces.ElevatorInterface;

public class Elevator implements ElevatorInterface {
    public static final int MAX_PASSENGERS = 10;
    private int[] passengers = new int[MAX_PASSENGERS]; //array passengers in elevator
    private int currentFloor = 1;
    private int maxFloor;
    private boolean direction = true; //true - UP , false - DOWN

    public Elevator(int maxFloor) {
        this.maxFloor = maxFloor;
    }

    public int move() {
        this.correctDirrection();

        int nextFloor;
        if (!this.isFull()) {
            nextFloor = direction ? currentFloor + 1 : currentFloor - 1;
        } else nextFloor = findClosestPassengerFloorIfElevatorFull();
        currentFloor = nextFloor;
        return nextFloor;
    }

    public boolean isFull() {
        boolean isElevatorFull = true;
        for (int i = 0; i < MAX_PASSENGERS; i++)
            if (passengers[i] == 0) {
                isElevatorFull = false;
                break;
            }
        return isElevatorFull;
    }

    @Override
    public void correctDirection() {
        if (currentFloor == 1) direction = true;
        else if (currentFloor == maxFloor) direction = false;
    }

    public boolean isEmpty() {
        for (int i : passengers)
            if (i != 0) return false;
        return true;
    }

    public void addPassenger(int passengerFloor) {
        for (int i = 0; i < MAX_PASSENGERS; i++)
            if (passengers[i] == 0) {
                passengers[i] = passengerFloor;
                return;
            }
    }

    public int removePassengers() {
        int removedPassengersCount = 0;
        for (int i = 0; i < MAX_PASSENGERS; i++)
            if (passengers[i] == currentFloor) {
                passengers[i] = 0;
                removedPassengersCount++;
            }
        return removedPassengersCount;
    }

    public boolean isDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void correctDirrection() {
        if (currentFloor == 1) direction = true;
        else if (currentFloor == maxFloor) direction = false;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int passenger : passengers) {
            if (passenger != 0)
                res.append(passenger).append(" ");
        }
        if (res.length() > 0) res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    private int findClosestPassengerFloorIfElevatorFull() {
        int result = 0;
        if (direction) {
            int min = maxFloor + 1;
            for (int i : passengers)
                if (i != 0 && i < min) min = i;
            result = (min != maxFloor + 1) ? min : 0;
        } else {
            int max = 0;
            for (int i : passengers)
                if (i > max) max = i;
            result = max;
        }
        if (result == 0) throw new IllegalStateException("Method can`t find next floor!");
        return result;
    }
}