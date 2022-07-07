package ua.com.javarush.generics;

import java.util.List;

public abstract class ExtendsVsSuper {
    //Работает с одним и тем же типом
    public abstract <T> void one(List<T> destination, List<T> source);

    //Добавляет любых наследников типа Т в список, умеющий хранить только тип Т
    public abstract <T> void two(List<T> destination, List<? extends T> source);

    //Добавляет обьекты типа Т в любой список, параметризованный любым родительским классом
    public abstract <T> void three(List<? super T> destination, List<T> source);

    //Добавляет любых насдедников типа Т в список, параметризованный любым родительским классом
    public abstract <T> void four(List<? super T> destination, List<? extends T> source);
}