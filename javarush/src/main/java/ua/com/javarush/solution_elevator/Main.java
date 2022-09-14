package ua.com.javarush.solution_elevator;

public class Main {
    public static void main(String[] args) {
        System.out.println("===========================");
        Initialization.initListFloors();
        for (int i = Initialization.listFloors.size() - 1; i >= 0; i--) {
            System.out.println(Initialization.listFloors.get(i));
        }

        System.out.println(" +++++++++++++++++");
        LogicToWorkElevator.startFromFirstFloor();
    }
}