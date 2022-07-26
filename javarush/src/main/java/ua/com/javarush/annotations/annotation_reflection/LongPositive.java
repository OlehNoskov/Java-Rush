package ua.com.javarush.annotations.annotation_reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Показывает где будет видна наша аннотация: в данном случае аннотация доступна во время выполнения программы
@Retention(RetentionPolicy.RUNTIME)
// Показывает что мы помечаем: в данном случае поле класса
@Target(value = ElementType.FIELD)
// Создание своей аннотации
public @interface LongPositive {
}