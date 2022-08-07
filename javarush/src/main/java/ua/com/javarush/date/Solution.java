package ua.com.javarush.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;


public class Solution {
    public static void main(String[] args) {
        System.out.println(isLeap(LocalDate.of(2000, 10, 10)));
        System.out.println(isBefore(LocalDateTime.of(2030,10,20,10,10,10)));
        System.out.println(isBefore(LocalDateTime.of(2000,10,20,10,10,10)));
    }

    // Год высокосный?
    public static boolean isLeap(LocalDate date) {
        return date.getYear() % 4 == 0;
    }

    // Дата предшевствует текущей дате?
    public static boolean isBefore(LocalDateTime dateTime) {
        return LocalDate.now().isBefore(ChronoLocalDate.from(dateTime));
    }

    public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {
        return null;
    }

    // Возвращает вренменной промежутоке между датами
    public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) {
        return null;
    }
}