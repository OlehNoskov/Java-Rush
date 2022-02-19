package ua.com.javarush.multithreading.inner_classes.implements_interface;

public class Mouse implements Pet, Sayable {

    @Override
    public Sayable toSayable(int i) {
        return this;
    }

    @Override
    public String say() {
        return "Мышь пищит.";
    }
}