package ua.com.javarush.multithreading.inner_classes.enums;

import java.util.*;

public class SecondSolution {

    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            Set<Wheel> wheelSet = new HashSet<>(4);
            String[] wheelNamesFromDb = loadWheelNamesFromDB();
            if (wheelNamesFromDb.length != 4) throw new IllegalArgumentException();
            for (String wheelName : wheelNamesFromDb) {
                wheelSet.add(Wheel.valueOf(wheelName));
            }
            if (wheelSet.size() != 4) throw new IllegalArgumentException();
            wheels = new ArrayList<>(wheelSet);
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }

        @Override
        public String toString() {
            return "Car{" +
                    "wheels=" + wheels +
                    '}';
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.toString());
    }
}