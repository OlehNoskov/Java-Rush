package ua.com.javarush.strategy_pattern.strategy;

import com.google.common.collect.HashBiMap;

public class HasBiMapStorageStrategy implements StorageStrategy {

    // HashMap from Guava
    private HashBiMap<Long, String> data = HashBiMap.create();

    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    // Возвращаем ключ благодаря тому, что мы перевернули
    // Мар и у нас значение стало ключом и наоборот -ключ стал значением
    @Override
    public Long getKey(String value) {
        return data.inverse().get(value);
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}