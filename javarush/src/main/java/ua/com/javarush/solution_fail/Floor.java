package ua.com.javarush.solution_fail;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Floor {
    @Getter
    @Setter
    private int numberFloor;
    @Getter
    @Setter
    private List<Passenger> listPassengers;

    public Floor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String toString() {
        return "Floor №" + numberFloor + " " + listPassengers;
    }
}