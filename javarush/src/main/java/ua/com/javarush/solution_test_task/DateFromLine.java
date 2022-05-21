package ua.com.javarush.solution_test_task;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class DateFromLine {

    private static final SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd.MM.yyyy");

    public static Date getDateStartQuery(String dateString) {
        Date date = new Date();
        try {
            date = simpleFormatter.parse(BaseQuery.getDate(dateString));
        } catch (ParseException e) {
            System.out.println("Sorry, date is incorrect!");
        }
        return date;
    }

    public static Date getDateEndQuery(String dateString) {
        Date date = new Date();
        try {
            String[] arrayDate = BaseQuery.getDate(dateString).split("-");
            if (arrayDate.length > 1) {
                date = simpleFormatter.parse(arrayDate[1]);
            } else {
                date = simpleFormatter.parse(arrayDate[0]);
            }
        } catch (ParseException e) {
            System.out.println("Sorry, date is incorrect!");
        }
        return date;
    }

    static boolean isValidDate(String date1, String date2) {
        return DateFromLine.getDateStartQuery(date2).before(DateFromLine.getDateEndQuery(date1))
                && DateFromLine.getDateEndQuery(date2).after(DateFromLine.getDateStartQuery(date1));
    }
}