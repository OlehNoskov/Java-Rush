package ua.com.javarush.pattern_factory_method.male;

import ua.com.javarush.pattern_factory_method.AbstractFactory;
import ua.com.javarush.pattern_factory_method.Human;

// Паттерн Factory method
public class MaleFactory implements AbstractFactory {
    @Override
    public Human getPerson(int age) {
        if (age > 0 && age <= KidBoy.MAX_AGE) {
            return new KidBoy();
        } else if (age > KidBoy.MAX_AGE && age <= TeenBoy.MAX_AGE) {
            return new TeenBoy();
        } else {
            return new Man();
        }
    }
}