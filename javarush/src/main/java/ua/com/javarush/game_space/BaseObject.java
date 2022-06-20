package ua.com.javarush.game_space;

public abstract class BaseObject {
    protected double x;
    protected double y;
    protected double radius;

    private boolean isAlive;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.isAlive = true;
    }

    public void draw(Canvas canvas){

    }

    public void move(){

    }

    public void die(){
        isAlive = false;
    }

    /**
     * Проверяем - пересекаются ли переданный(o) и наш(this) объекты.
     */
    public boolean isIntersect(BaseObject object){
        double dx = x - object.x;
        double dy = y - object.y;

        double distance = Math.sqrt(dx * dx + dy * dy);
        double distance2 = Math.max(radius, object.radius);
        return distance <= distance2;
    }

    /**
     * Проверяем - не выходит ли (x,y) за границы.
     */
    public void checkBorders(double minx, double maxx, double miny, double maxy) {
        if (x < minx) x = minx;
        if (x > maxx) x = maxx;
        if (y < miny) y = miny;
        if (y > maxy) y = maxy;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean isAlive() {
        return isAlive;
    }
}