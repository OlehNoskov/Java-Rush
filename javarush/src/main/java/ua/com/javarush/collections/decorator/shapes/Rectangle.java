package ua.com.javarush.collections.decorator.shapes;

public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing a shape: RECTANGLE!");
    }
}