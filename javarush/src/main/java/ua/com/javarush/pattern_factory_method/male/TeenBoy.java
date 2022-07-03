package ua.com.javarush.pattern_factory_method.male;

import ua.com.javarush.pattern_factory_method.Human;

public class TeenBoy implements Human {
    public static final int MAX_AGE = 19;

    @Override
    public String toString() {
        return "TeenBoy{}";
    }
}