package ua.com.javarush.recursion;

public class RecursionExample {
    public static void main(String[] args) {
        countDown(10);
    }

    public static void countDown(int x) {
        if (x <= 0) {
            System.out.println("Recursion is done!");
        } else {
            System.out.println(x);
            countDown(x - 1);
        }
    }
}