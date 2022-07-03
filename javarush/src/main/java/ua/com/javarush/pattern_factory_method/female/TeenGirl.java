package ua.com.javarush.pattern_factory_method.female;

import ua.com.javarush.pattern_factory_method.Human;

public class TeenGirl implements Human {
    public static final int MAX_AGE = 19;

    @Override
    public String toString() {
        return "TeenGirl{}";
    }
}