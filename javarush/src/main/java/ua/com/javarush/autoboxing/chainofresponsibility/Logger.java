package ua.com.javarush.autoboxing.chainofresponsibility;

public interface Logger {
    void inform(String message, int level);

    void setNext(Logger next);

    void info(String message);
}