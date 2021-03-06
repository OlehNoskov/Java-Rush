package ua.com.javarush.arkanoid;

public class Stand extends BaseObject {

    private double speed;
    private double direction;

    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void move() {
        double dx = speed * direction;
        x+=dx;
    }

    public void moveRight(){
        direction = 1;
    }

    public void moveLeft(){
        direction = -1;
    }
}