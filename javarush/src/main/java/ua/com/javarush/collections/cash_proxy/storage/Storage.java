package ua.com.javarush.collections.cash_proxy.storage;

public interface Storage {

    void add(Object o);

    Object get(long id);
}