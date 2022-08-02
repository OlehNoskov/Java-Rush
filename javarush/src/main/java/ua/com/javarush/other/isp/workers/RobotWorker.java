package ua.com.javarush.other.isp.workers;

public class RobotWorker implements Worker {
    @Override
    public void work() {
        System.out.println("RobotWorker is working!");
    }
}