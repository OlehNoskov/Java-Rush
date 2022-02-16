package ua.com.javarush.arkanoid;

public class Ball extends BaseObject{

    public Ball(double x, double y, double radius) {
        super(x, y, radius);
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void move() {
        System.out.println("Ball");
    }
}
