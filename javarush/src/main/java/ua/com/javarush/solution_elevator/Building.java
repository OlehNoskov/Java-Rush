package ua.com.javarush.solution_elevator;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

public class Building {
    private static Building instance = null;
    private static final int MIN_AMOUNT_FLOORS = 5;
    private static final int MAX_AMOUNT_FLOORS = 20;
    public static final int FIRST_FLOOR = 1;
    public static int RANDOM_AMOUNT_FLOORS = Initialization.RANDOM_NUMBER.nextInt(Building.MIN_AMOUNT_FLOORS, Building.MAX_AMOUNT_FLOORS) + 1;

    @Setter
    @Getter
    private List<Floor> listFloors = new LinkedList<>();

    private Building() {
    }

    public static Building getInstance() {
        if (instance == null) {
            instance = new Building();
        }
        return instance;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = listFloors.size() - 1; i >= 0; i--) {
            stringBuilder.append(listFloors.get(i).toString()).append(" ");
            if (Elevator.getInstance().getCurrentFloor() == listFloors.get(i).getNumberFloor()) {
                stringBuilder.append(Elevator.getInstance().toString()).append("\n");
            } else {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}