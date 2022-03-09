package ua.com.javarush.multithreading.concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class SecondConsumer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public SecondConsumer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted()) {
            if (!map.isEmpty()) {
                for (String key : map.keySet()) {
                    System.out.println(map.remove(key));
                }
            }
        }
    }
}
