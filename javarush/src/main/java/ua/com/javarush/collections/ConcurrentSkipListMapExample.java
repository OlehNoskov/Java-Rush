package ua.com.javarush.collections;

import java.util.concurrent.ConcurrentSkipListMap;

/** ConcurrentSkipListMap - реализует интерфейс Map,
 * истолбзутеся при работе с тредами, является неблокирующей версией
 * списка с пропусками, адаптирован для хэщ-таблиц
 */

public class ConcurrentSkipListMapExample {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        return ConcurrentSkipListMap.class;
    }
}