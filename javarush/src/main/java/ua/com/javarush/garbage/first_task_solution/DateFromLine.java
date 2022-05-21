package ua.com.javarush.garbage.first_task_solution;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFromLine {

    private static final SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd.MM.yyyy");

    static Date getDateCreateWaitTimeDate(String query) {
        Date date = new Date();
        try {
            date = simpleFormatter.parse(QueryStringData.getDateString(query));
        } catch (ParseException e) {
            System.out.println("Sorry, date is incorrect!");
        }
        return date;
    }

    static Date getDateStartQuery(String query) {
        return getDate(QueryStringData.getDateString(query), simpleFormatter, query);
    }

    public static Date getDate(String dateString, SimpleDateFormat simpleFormatter, String query) {
        Date date = new Date();
        try {
            String[] arrayDate = dateString.split("-");
            date = simpleFormatter.parse(arrayDate[0]);
        } catch (ParseException e) {
            System.out.println("Sorry, date is incorrect!");
        }
        return date;
    }

    static Date getDateEndQuery(String query) {
        return getDate(QueryStringData.getDateString(query), simpleFormatter, query);
    }

    static boolean isValidDate(String date1, String date2) {
        return DateFromLine.getDateCreateWaitTimeDate(date2).before(DateFromLine.getDateEndQuery(date1))
                && DateFromLine.getDateCreateWaitTimeDate(date2).after(DateFromLine.getDateStartQuery(date1));
    }
}