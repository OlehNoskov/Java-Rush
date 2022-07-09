package ua.com.javarush.strategy_pattern;

public class ExceptionHandler {

    public static void log(Exception e) {
        Helper.printMessage(e.toString());
    }
}