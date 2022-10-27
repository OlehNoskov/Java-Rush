package ua.com.javarush.other;

public class Test implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread");
    }

    public static void main(String[] args) {
        new Test().run();
    }
}
