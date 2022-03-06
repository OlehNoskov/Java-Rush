package ua.com.javarush.multithreading.threads.task;

public class FirstSolution extends Thread {

    public FirstSolution() {
        this.setUncaughtExceptionHandler((t, e) -> {
            String message;
            if (e instanceof Error) message = "Нельзя дальше работать";
            else if (e instanceof Exception) message = "Надо обработать";
            else message = "Поживем - увидим";
            System.out.println(message);
        });
    }

    public static void main(String[] args) {
    }
}