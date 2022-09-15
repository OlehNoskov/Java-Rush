package ua.com.javarush.solution_elevator;

import ua.com.javarush.solution_elevator.models.Building;

import java.util.Random;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {
        Building building = new Building((random.nextInt(Building.MIN_AMOUNT_FLOORS, Building.MAX_AMOUNT_FLOORS) + 1));
        System.out.println("===== START =====");
        System.out.println(building);
        building.run();
    }
}
