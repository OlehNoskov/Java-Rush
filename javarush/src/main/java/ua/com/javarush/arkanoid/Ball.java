package ua.com.javarush.arkanoid;

public class Ball extends BaseObject {

    private double speed;
    private double direction;
    private double distanceX;
    private double distanceY;
    private boolean isFrozen;

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
        this.isFrozen = true;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDistanceX() {
        return distanceX;
    }

    public double getDistanceY() {
        return distanceY;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'O');
    }

    @Override
    public void move() {
        if (!isFrozen) {
            x += distanceX;
            y += distanceY;
        }
    }

    void start() {
        this.isFrozen = false;
    }

    void setDirection(double direction) {
        this.direction = direction;
        double angle = Math.toRadians(direction);
        distanceX = Math.cos(angle) * speed;
        distanceY = Math.sin(angle) * speed;
    }

    void checkRound(int minX, int maxX, int minY, int maxY){
    }
}