package ua.com.javarush.strategy_pattern.strategy;

import java.util.HashMap;

/** Пример реализации Мар, работающий в две стороны -
 * по ключу получать значение, а по значению ключ (Guava from Google)
*/

public class OurHashBiMapStorageStrategy implements StorageStrategy {
    HashMap<Long, String> k2v = new HashMap<>();
    HashMap<String, Long> v2k = new HashMap<>();

    @Override
    public boolean containsKey(Long key) {
        return k2v.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return v2k.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        k2v.put(key, value);
        v2k.put(value, key);
    }

    @Override
    public Long getKey(String value) {
        return v2k.get(value);
    }

    @Override
    public String getValue(Long key) {
        return k2v.get(key);
    }
}