package ua.com.javarush.generics.second;

public class Puppy extends Dog {
    public Puppy(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Щенок " + name;
    }
}