package ua.com.javarush.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateMethods {
    public static void main(String[] args) {
        System.out.println(isLeap(LocalDate.of(2000, 10, 10)));
        System.out.println("=====================================");

        System.out.println(isBefore(LocalDateTime.of(2030, 10, 20, 10, 10, 10)));
        System.out.println(isBefore(LocalDateTime.of(2000, 10, 20, 10, 10, 10)));
        System.out.println("=====================================");

        System.out.println(addTime(LocalTime.now(), 10, ChronoUnit.HOURS));
        System.out.println("=====================================");

        System.out.println(getPeriodBetween(LocalDate.of(2000, 10, 20)
                , LocalDate.of(2010, 12, 22)));
    }

    // Год высокосный?
    public static boolean isLeap(LocalDate date) {
        return date.isLeapYear();
    }

    // Дата предшевствует текущей дате?
    public static boolean isBefore(LocalDateTime dateTime) {
        return dateTime.isBefore(LocalDateTime.now());
    }

    // Возвращает время увеличенное на n chronoUnites
    public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {
        return time.plus(n, chronoUnit);
    }

    // Возвращает временной промежутоке между датами
    public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) {
        return Period.between(firstDate, secondDate);
    }
}