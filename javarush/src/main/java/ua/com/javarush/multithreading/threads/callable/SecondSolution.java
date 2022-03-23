package ua.com.javarush.multithreading.threads.callable;

import java.util.LinkedHashMap;

public class SecondSolution {
    public static void main(String[] args) {
        ReadWriteMap<Integer, String> linkedSafeMap = new ReadWriteMap<>(new LinkedHashMap<>());
    }
}