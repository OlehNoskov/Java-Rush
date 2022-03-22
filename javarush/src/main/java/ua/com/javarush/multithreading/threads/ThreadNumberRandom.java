package ua.com.javarush.multithreading.threads;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadNumberRandom {
    //Методы возвращают рандомные числа в многопоточной среде

    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }

    public static double getRandomDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n) {
        return ThreadLocalRandom.current().nextLong( n + 1);
    }

    public static void main(String[] args) {
    }
}