package ua.com.javarush.solution_test_task;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class DateFromLine {

    private static final SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd.MM.yyyy");

    static Date getDateStartQuery(String dateString) {
        Date date = new Date();
        try {
            date = simpleFormatter.parse(BaseQuery.getDate(dateString));
        } catch (ParseException e) {
            System.out.println("Sorry, date is incorrect!");
        }
        return date;
    }

    static Date getDateEndQuery(String dateString) {
        Date date = new Date();
        try {
            String[] arrayDate = BaseQuery.getDate(dateString).split("-");
            if (arrayDate.length > 1) {
                date = simpleFormatter.parse(arrayDate[BaseQuery.FIRST_INDEX]);
            } else {
                date = simpleFormatter.parse(arrayDate[BaseQuery.ZERO_INDEX]);
            }
        } catch (ParseException e) {
            System.out.println("Sorry, date is incorrect!");
        }
        return date;
    }

    static boolean isDateInSearchArea(Date startDate, Date endDate, Date createTimeline) {
        boolean result;
        if (startDate.equals(endDate)) {
            result = createTimeline.before(startDate);
        } else {
            result = startDate.before(createTimeline) && endDate.after(createTimeline);
        }
        return result;
    }
}