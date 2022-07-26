package ua.com.javarush.annotations.realize_annotations;

// Создание своей аннотации
public @interface Date {
    int year();
    int month();
    int day();
    int hour();
    int minute();
    int second();
}