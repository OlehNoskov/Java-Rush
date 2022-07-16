package ua.com.javarush.collections.decorator;

import ua.com.javarush.collections.decorator.decorators.RedShapeDecorator;
import ua.com.javarush.collections.decorator.shapes.Circle;
import ua.com.javarush.collections.decorator.shapes.Rectangle;
import ua.com.javarush.collections.decorator.shapes.Shape;

public class Solution {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Simple circle");
        circle.draw();

        System.out.println("\nApplied RedShapeDecorator to the circle");
        redCircle.draw();

        System.out.println("\nApplied RedShapeDecorator to the rectangle");
        redRectangle.draw();
    }
}