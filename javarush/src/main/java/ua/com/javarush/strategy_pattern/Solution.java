package ua.com.javarush.strategy_pattern;

import ua.com.javarush.strategy_pattern.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        long elementsNumber = 10_000L;
        testStrategy(new HashMapStorageStrategy(), elementsNumber);
        testStrategy(new OurHashBiMapStorageStrategy(), elementsNumber);
        testStrategy(new HasBiMapStorageStrategy(), elementsNumber);
        testStrategy(new DualHashBidiMapStorageStrategy(), elementsNumber);
    }

    public static void testStrategy(StorageStrategy storageStrategy, long elementsNumber) {
        System.out.println(storageStrategy.getClass().getSimpleName() + ":");
        Set<String> randomValues = new HashSet<>();
        Shortener shortener = new Shortener(storageStrategy);
        Date start, finish;

        for (int i = 0; i < elementsNumber; i++) {
            randomValues.add(Helper.generateRandomString());
        }

        start = new Date(System.currentTimeMillis());
        getIds(shortener, randomValues);
        finish = new Date(System.currentTimeMillis());
        long time = finish.getTime() - start.getTime();

        Helper.printMessage("Time work getIds: " + time + " milliseconds.");

        start = new Date(System.currentTimeMillis());
        Set<String> values = getStrings(shortener, getIds(shortener, randomValues));
        finish = new Date(System.currentTimeMillis());
        time = finish.getTime() - start.getTime();

        Helper.printMessage("Time work getStrings: " + time + " milliseconds.");

        if (randomValues.equals(values))
            Helper.printMessage("Тест пройден." + "\n");
        else
            Helper.printMessage("Тест не пройден."+ "\n");
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> setKeys = new HashSet<>();
        for (String string : strings) {
            setKeys.add(shortener.getId(string));
        }
        return setKeys;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> setValues = new HashSet<>();
        for (Long key : keys) {
            setValues.add(shortener.getString(key));
        }
        return setValues;
    }
}