package ua.com.javarush.annotations.realize_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
// Показывает где будет видна наша аннотация: в данном случае аннотация доступна во время выполнения программы
@Retention(value = RetentionPolicy.RUNTIME)
// Создание своей аннотации
public @interface Author {
    String value();
    Position position() default Position.OTHER;
}