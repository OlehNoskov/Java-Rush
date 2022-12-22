package ua.com.javarush.other.two_interfaces;

public class Test implements First, Second {
    public static void main(String[] args) {
        new Test().run();
    }

    @Override
    public  void run() {
        System.out.println("Ok!!!");
    }
}