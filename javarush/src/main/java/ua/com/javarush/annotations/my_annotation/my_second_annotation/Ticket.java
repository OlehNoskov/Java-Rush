package ua.com.javarush.annotations.my_annotation.my_second_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Показывает где будет видна наша аннотация: в данном случае аннотация доступна во время выполнения программы
@Retention(value = RetentionPolicy.RUNTIME)
// Показывает что мы можем пометить: в данном случае класс интерфейс enum
@Target(value = ElementType.TYPE)
public @interface Ticket {
    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    // Значения по умолчанию
    Priority priority() default Priority.MEDIUM;

    String[] tags() default {};

    String createdBy() default "Amigo";
}