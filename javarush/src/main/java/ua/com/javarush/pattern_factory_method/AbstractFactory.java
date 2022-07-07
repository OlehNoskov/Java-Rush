package ua.com.javarush.pattern_factory_method;

public interface AbstractFactory {
    Human getPerson(int age);
}