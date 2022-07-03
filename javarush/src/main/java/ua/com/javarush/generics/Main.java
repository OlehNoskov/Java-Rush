package ua.com.javarush.generics;

public class Main {
    public static void main(String[] args) {
        Number number = GenericStatic.<Number>someStaticMethod(3);
    }
}