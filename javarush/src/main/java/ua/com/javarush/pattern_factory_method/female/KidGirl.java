package ua.com.javarush.pattern_factory_method.female;

import ua.com.javarush.pattern_factory_method.Human;

public class KidGirl implements Human {
    public static final int MAX_AGE = 12;

    @Override
    public String toString() {
        return "KidGirl{}";
    }
}