package ua.com.javarush.collections.decorator.decorators;

import ua.com.javarush.collections.decorator.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        setBorderColor(decoratedShape);
        decoratedShape.draw();
    }

    private void setBorderColor(Shape shape) {
        System.out.println("Setting border color for " + shape.getClass().getSimpleName() + " to red.");
    }
}