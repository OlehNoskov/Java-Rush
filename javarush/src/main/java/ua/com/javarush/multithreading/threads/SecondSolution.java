package ua.com.javarush.multithreading.threads;

public class SecondSolution {

    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread thread : threads) {
            Thread.State currentState = thread.getState();

            switch (currentState) {
                case NEW -> thread.start();
                case WAITING, TIMED_WAITING, BLOCKED -> thread.interrupt();
                case RUNNABLE -> thread.isInterrupted();
                case TERMINATED -> System.out.println(thread.getPriority());
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread();
        processThreads(thread);
    }
}