package ua.com.javarush.solution_elevator;

import ua.com.javarush.solution_elevator.models.Building;

import java.util.Random;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {

        Building building = new Building((random.nextInt(16)+5)); // (0...15) +5 = 5... 20
        System.out.println("START");
        System.out.println(building);
        building.startCycle();
    }
}
