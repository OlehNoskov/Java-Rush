package ua.com.javarush.generics.second;

public class Kitten extends Cat {
    public Kitten(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Котенок " + name;
    }
}