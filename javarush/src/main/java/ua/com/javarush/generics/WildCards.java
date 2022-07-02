package ua.com.javarush.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class WildCards {
    // ? super H -> говорит компилятору, что метод add()
    // может принимать на вход коллекцию объектов класса наследника H либо любого другого класса-предка H.

    // ? extends H ->  Это значит, что метод принимает на вход коллекцию объектов класса H
    // либо объектов любого класса-наследника H (? extends Animal)
    public static <H> void add(List<? super H> destinationList, List<? extends H> sourceList) {
        ListIterator<? super H> destListIterator = destinationList.listIterator();
        ListIterator<? extends H> srcListIterator = sourceList.listIterator();
        for (int i = 0; i < sourceList.size(); i++) {
            destListIterator.add(srcListIterator.next());
        }
    }


    public static void main(String[] args) {
        List<B> destination = new ArrayList<>();
        destination.add(new B());
        List<C> source = new ArrayList<>();
        source.add(new C());
        add(destination, source);
        System.out.println(destination);
        System.out.println(source);
    }

    static class A {
    }

    static class B extends A {
    }

    static class C extends B {
    }
}