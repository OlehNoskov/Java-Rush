package ua.com.javarush.pattern_factory_method.male;

import ua.com.javarush.pattern_factory_method.Human;

public class KidBoy implements Human {
    public static final int MAX_AGE = 12;

    @Override
    public String toString() {
        return "KidBoy{}";
    }
}