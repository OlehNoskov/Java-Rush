package ua.com.javarush.parser_logs_my_solution;

import java.nio.file.Paths;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Solution {
    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get("example.log"));

        SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(logParser.getNumberOfUniqueIPs(simpleFormatter.parse("01.01.2010"), simpleFormatter.parse("01.01.2020")));
        System.out.println("=======================================");

        for (String string : logParser.getUniqueIPs(simpleFormatter.parse("01.01.2010"), simpleFormatter.parse("01.01.2020"))) {
            System.out.println(string);
        }
        System.out.println("=======================================");

        for (String string : logParser.getIPsForUser("Amigo", simpleFormatter.parse("01.01.2010"), simpleFormatter.parse("01.01.2030"))) {
            System.out.println(string);
        }
        System.out.println("=======================================");

        for (String string : logParser.getIPsForEvent(Event.SOLVE_TASK, simpleFormatter.parse("01.01.2010"), simpleFormatter.parse("01.01.2030"))) {
            System.out.println(string);
        }
        System.out.println("=======================================");

        for (String string : logParser.getIPsForStatus(Status.OK, simpleFormatter.parse("01.01.2010"), simpleFormatter.parse("01.01.2030"))) {
            System.out.println(string);
        }
    }
}