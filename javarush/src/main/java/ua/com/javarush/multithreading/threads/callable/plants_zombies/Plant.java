package ua.com.javarush.multithreading.threads.callable.plants_zombies;

import java.util.concurrent.atomic.AtomicInteger;

public class Plant extends Character {
    private final static AtomicInteger idSequence = new AtomicInteger();
    private final int id = idSequence.incrementAndGet();

    protected int getId() {
        return id;
    }
}