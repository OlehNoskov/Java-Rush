package ua.com.javarush.autoboxing.chainofresponsibility;

public class Solution {
    public static void main(String[] args) {
        Logger logger3 = new AbstractLogger(Level.FATAL);
        Logger logger2 = new AbstractLogger(Level.ERROR);
        Logger logger1 = new AbstractLogger(Level.WARN);
        Logger logger0 = new AbstractLogger(Level.INFO);

        logger3.setNext(logger2);
        logger2.setNext(logger1);
        logger1.setNext(logger0);

        logger3.inform("Everything is OK", Level.INFO);
        logger3.inform("We found a bug", Level.WARN);
        logger3.inform("Database connection error", Level.ERROR);
        logger3.inform("System shut down", Level.FATAL);
    }
}