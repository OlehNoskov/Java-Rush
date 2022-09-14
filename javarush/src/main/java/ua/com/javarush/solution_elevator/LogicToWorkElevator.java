package ua.com.javarush.solution_elevator;

public class LogicToWorkElevator {
    private Elevator elevator = Elevator.getInstance();

    public static void run() {

    }

    public static void startFromFirstFloor() {
        System.out.println(Initialization.listFloors.get(0));
    }
}