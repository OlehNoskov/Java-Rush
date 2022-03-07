package ua.com.javarush.multithreading.threads.uncaughtExceptionHandler;

public interface CustomThreadManipulator {

    public void start(String threadName);

    public void stop();
}