package ua.com.javarush.strategy_pattern.strategy;

import java.util.HashMap;

public class HashMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> data = new HashMap<>();

    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsKey(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        Long key = null;
        for (Long k : data.keySet()) {
            if (data.get(k).equals(value)) {
                key = k;
            }
        }
        return key;
    }

    @Override
    public String getValue(Long getKey) {
        return data.get(getKey);
    }
}