package ua.com.javarush.annotations.my_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Показывает что мы можем пометить: в данном случае класс интерфейс enum
@Target(value = ElementType.TYPE)
// Показывает где будет видна наша аннотация: в данном случае аннотация доступна во время выполнения программы
@Retention(value = RetentionPolicy.RUNTIME)
// Создание своей аннотации
@interface Person {
 String name () default "";
 int live();
 int strength();
 int magic() default 0;
 int attack() default 0;
 int defence();
}