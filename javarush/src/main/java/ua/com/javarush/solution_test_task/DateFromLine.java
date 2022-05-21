//package ua.com.javarush.solution_test_task;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//
//import java.util.Date;
//
//public class DateFromLine {
//
//    private static final SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd.MM.yyyy");
//
//    static Date getDateCreateWaitTimeDate(String query) {
//        Date date = new Date();
//        try {
//            date = simpleFormatter.parse(QueryStringData.getDateString(query));
//        } catch (ParseException e) {
//            System.out.println("Sorry, date is incorrect!");
//        }
//        return date;
//    }
//
//    static Date getDateStartQuery(String query) {
//        return getDate(QueryStringData.getDateString(query), simpleFormatter, query);
//    }
//
//    static Date getDateEndQuery(String query) {
//        return getDate(QueryStringData.getDateString(query), simpleFormatter, query);
//    }
//
//    public static Date getDate(String dateString, SimpleDateFormat simpleFormatter, String query) {
//        Date date = new Date();
//        try {
//            String dates = dateString;
//            String[] arrayDate = dates.split("-");
//            if (arrayDate.length > 1) {
//                date = simpleFormatter.parse(arrayDate[1]);
//            } else {
//                date = simpleFormatter.parse(arrayDate[0]);
//            }
//        } catch (ParseException e) {
//            System.out.println("Sorry, date is incorrect!");
//        }
//        return date;
//    }
//
//    static boolean isValidDate(String date1, String date2) {
//        return DateFromLine.getDateCreateWaitTimeDate(date2).before(DateFromLine.getDateEndQuery(date1))
//                && DateFromLine.getDateCreateWaitTimeDate(date2).after(DateFromLine.getDateStartQuery(date1));
//    }
//}