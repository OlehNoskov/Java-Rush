package ua.com.javarush.pattern_factory_method.female;

import ua.com.javarush.pattern_factory_method.AbstractFactory;
import ua.com.javarush.pattern_factory_method.Human;

public class FemaleFactory implements AbstractFactory {
    @Override
    public Human getPerson(int age) {
        if (age > 0 && age <= KidGirl.MAX_AGE) {
            return new KidGirl();
        } else if (age > KidGirl.MAX_AGE && age <= TeenGirl.MAX_AGE) {
            return new TeenGirl();
        } else {
            return new Woman();
        }
    }
}