package ua.com.javarush.multithreading.threads.task;

public interface CustomThreadManipulator {

    public void start(String threadName);

    public void stop();
}