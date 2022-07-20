package ua.com.javarush.parser_logs_my_solution;

import java.nio.file.Paths;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Solution {
    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get("example.log"));

        SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd.MM.yyyy");

        for (String name : logParser.getAllUsers()) {
            System.out.println(name);
        }
        System.out.println("========================");

        System.out.println(logParser.getNumberOfUsers(simpleFormatter.parse("06.01.2010"), simpleFormatter.parse("01.01.2030")));
        System.out.println("========================");

        System.out.println(logParser.getNumberOfUserEvents("Vasya Pupkin",simpleFormatter.parse("06.01.2010"), simpleFormatter.parse("01.01.2030")));
        System.out.println("========================");

        for (String name : logParser.getUsersForIP("192.168.100.2", simpleFormatter.parse("06.01.2010"), simpleFormatter.parse("01.01.2030"))) {
            System.out.println(name);
        }
        System.out.println("========================");

        for (String name : logParser.getLoggedUsers(simpleFormatter.parse("06.01.2010"), simpleFormatter.parse("01.01.2030"))) {
            System.out.println(name);
        }
        System.out.println("========================");

        for (String name : logParser.getDownloadedPluginUsers(simpleFormatter.parse("06.01.2010"), simpleFormatter.parse("01.01.2030"))) {
            System.out.println(name);
        }
        System.out.println("========================");

        for (String name : logParser.getWroteMessageUsers(simpleFormatter.parse("06.01.2010"), simpleFormatter.parse("01.01.2030"))) {
            System.out.println(name);
        }
        System.out.println("========================");

        for (String name : logParser.getSolvedTaskUsers(simpleFormatter.parse("06.01.2010"), simpleFormatter.parse("01.01.2030"))) {
            System.out.println(name);
        }
        System.out.println("========================");

        for (String name : logParser.getSolvedTaskUsers(simpleFormatter.parse("06.01.2010"), simpleFormatter.parse("01.01.2030"), 18)) {
            System.out.println(name);
        }
        System.out.println("========================");

        for (String name : logParser.getDoneTaskUsers(simpleFormatter.parse("06.01.2010"), simpleFormatter.parse("01.01.2030"))) {
            System.out.println(name);
        }
        System.out.println("========================");

        for (String name : logParser.getDoneTaskUsers(simpleFormatter.parse("06.01.2010"), simpleFormatter.parse("01.01.2030"), 15)) {
            System.out.println(name);
        }
        System.out.println("========================");
    }
}