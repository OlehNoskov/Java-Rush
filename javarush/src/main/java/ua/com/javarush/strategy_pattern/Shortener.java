package ua.com.javarush.strategy_pattern;

import ua.com.javarush.strategy_pattern.strategy.StorageStrategy;

public class Shortener {
    private Long lastId = 0L;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    // Возвращает идентификатор для заданной строки
    public synchronized long getId(String string) {
        if (storageStrategy.containsValue(string)) {
            return storageStrategy.getKey(string);
        } else {
            lastId++;
            storageStrategy.put(lastId, string);
            return lastId;
        }
    }

    // Возвращает строку для заданного идентификатора или null если он не найден
    public synchronized String getString(Long id) {
        return storageStrategy.getValue(id);
    }
}