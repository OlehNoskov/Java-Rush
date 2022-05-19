package ua.com.javarush.solution_test_task;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class MyDate {

    private static final SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd.MM.yyyy");

    static Date getDateCreateWaitTimeDate(String query) {
        Date date = new Date();
        try {
            if (WaitTime.getSymbolWaitTime().equals(QueryStringData.getTypeQuery(query))) {
                date = simpleFormatter.parse(QueryStringData.getDateString(query));
            }
        } catch (ParseException e) {
            System.out.println("Sorry, date is incorrect!");
        }
        return date;
    }

    static Date getDateStartQuery(String query) throws ParseException {
        Date date = new Date();
        if (Query.getSymbolQuery().equals(QueryStringData.getTypeQuery(query))) {
            String dates = QueryStringData.getDateString(query);
            String[] arrayDate = dates.split("-");
            date = simpleFormatter.parse(arrayDate[0]);
        }
        return date;
    }

    static Date getDateEndQuery(String query) {
        Date date = new Date();
        try {
            if (Query.getSymbolQuery().equals(QueryStringData.getTypeQuery(query))) {
                String dates = QueryStringData.getDateString(query);
                String[] arrayDate = dates.split("-");
                if (arrayDate.length > 1) {
                    date = simpleFormatter.parse(arrayDate[1]);
                }
            }
        } catch (ParseException e) {
            System.out.println("Sorry, date is incorrect!");
        }
        return date;
    }
}
