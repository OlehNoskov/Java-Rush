package ua.com.javarush.parser_logs_my_solution;

import java.nio.file.Paths;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get("example.log"));

        SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd.MM.yyyy");

        for (Object object : logParser.execute("get ip")){
            System.out.println(object);
        }
    }
}