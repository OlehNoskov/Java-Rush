package ua.com.javarush.web.waitnotify.first_task;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        while (!isValuePresent) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isValuePresent = false;
        System.out.println("Got: " + value);
        notify();
        return value;
    }

    public synchronized void put(int value) {
        //System.out.println("Put before: " + value);
        while (isValuePresent) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value = value;
        isValuePresent = true;
        System.out.println("Put: " + value);
        notify();
    }
}