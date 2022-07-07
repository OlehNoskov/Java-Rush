package ua.com.javarush.mvc.second_example;

public class SpeedometerView {
    public void printCarDetails(String brand, String model, int speed) {
        System.out.println("Car: \nBrand: " + brand + "\nModel: " + model + "\nCurrent Speed: " + speed + "\n");
    }
}