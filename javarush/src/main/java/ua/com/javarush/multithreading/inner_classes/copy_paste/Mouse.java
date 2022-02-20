package ua.com.javarush.multithreading.inner_classes.copy_paste;

public class Mouse implements Pet,Sayable {

    @Override
    public Sayable toSayable(int i) {
        return this;
    }

    @Override
    public String say() {
        return "Мышь пищит.";
    }
}