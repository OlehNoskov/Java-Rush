package ua.com.javarush.pattern_factory_method;

import ua.com.javarush.pattern_factory_method.female.FemaleFactory;
import ua.com.javarush.pattern_factory_method.male.MaleFactory;

public class FactoryProducer {
    public enum HumanFactoryType {
        MALE, FEMALE
    }

    public static AbstractFactory getFactory(HumanFactoryType type) {
        if (type == HumanFactoryType.MALE) {
            return new MaleFactory();
        } else {
            return new FemaleFactory();
        }
    }
}