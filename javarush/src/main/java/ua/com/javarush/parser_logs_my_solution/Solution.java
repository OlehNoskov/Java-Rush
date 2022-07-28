package ua.com.javarush.parser_logs_my_solution;

import java.nio.file.Paths;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Solution {
    private static final SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get("example.log"));

        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(simpleFormatter.parse("01.01.2010 00:00:00"), simpleFormatter.parse("01.01.2030 00:00:00")));
    }
}