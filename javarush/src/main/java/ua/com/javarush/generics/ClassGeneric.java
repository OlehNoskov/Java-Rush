package ua.com.javarush.generics;

import java.util.List;

public class ClassGeneric<T extends List<ClassGeneric.SomeClass>> {
    public static class SomeClass <K extends Number> {
    }

    public static void main(String[] args) {

    }
}