package ua.com.javarush.strategy_pattern.strategy;

public interface StorageStrategy {
    // Возвращает true если содержит ключ
    boolean containsKey(Long key);

    //Возвращает true если содержит значение
    boolean containsValue(String value);

    // Добавить в хранилище новую пару ключ-значние
    void put(Long key, String value);

    // Получить ключ
    Long getKey(String value);

    // Получить значение
    String getValue(Long getKey);
}