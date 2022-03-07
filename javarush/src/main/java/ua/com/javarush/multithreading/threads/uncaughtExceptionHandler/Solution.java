package ua.com.javarush.multithreading.threads.uncaughtExceptionHandler;

import java.util.LinkedList;
import java.util.List;

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        List<String> res = new LinkedList<>();
        while (e != null) {
            res.add(0, e.toString());
            e = e.getCause(); // метод выводит цепочку исключений!
        }

        for (String s : res) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Thread thread = new Thread();

        IllegalAccessException illegalAccessException = new IllegalAccessException();
        solution.uncaughtException(thread, illegalAccessException);
    }
}