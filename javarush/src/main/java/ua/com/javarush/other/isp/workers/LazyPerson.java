package ua.com.javarush.other.isp.workers;

public class LazyPerson implements Eater, Sleeper {

    @Override
    public void eat() {
        System.out.println("LazyPerson is eating!");
    }

    @Override
    public void sleep() {
        System.out.println("LazyPerson is sleeping!");
    }
}