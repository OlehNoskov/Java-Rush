package ua.com.javarush.date;

import java.text.ParseException;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParseDateToItalian {
    public static void main(String[] args) throws ParseException {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
    }

    //Метод должен возвращать день недели на итальянском языке
    public static String getWeekdayOfBirthday(String birthday, String year) {
        DateTimeFormatter birthdayDateFormat = DateTimeFormatter.ofPattern("d.M.y");
        LocalDate birthdayDate = LocalDate.parse(birthday, birthdayDateFormat);

        DateTimeFormatter yearFormat = DateTimeFormatter.ofPattern("y");
        Year yearDate = Year.parse(year, yearFormat);
        return birthdayDate.withYear(yearDate.getValue()).format(DateTimeFormatter.ofPattern("EEEE").withLocale(Locale.ITALIAN));
    }
}