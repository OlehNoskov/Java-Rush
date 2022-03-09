package ua.com.javarush.multithreading.concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class SecondProducer implements Runnable {
    ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public SecondProducer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (true) {
                map.put(String.valueOf(i++), "Some text for " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}