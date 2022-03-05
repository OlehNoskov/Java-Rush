package ua.com.javarush.multithreading.threads.task;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    private TaskManipulator taskManipulator;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(String threadName) {
        this.taskManipulator = new TaskManipulator();
    }

    @Override
    public void stop() {

    }
}
