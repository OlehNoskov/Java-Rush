package ua.com.javarush.collections;

import java.util.Collections;

// Найти класс по описанию
public class GetExpectedClass {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        for (Class clazz : Collections.class.getDeclaredClasses()) {
            if (clazz.getSimpleName().equals("EmptyQueue")) {
                return clazz;
            }
        }
        return null;
    }
}
