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
        System.out.println("Stand");
    }

    public void moveRight(){
        this.direction = 1;
    }

    public void moveLeft(){
        this.direction = -1;
    }
}