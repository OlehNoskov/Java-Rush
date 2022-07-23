package ua.com.javarush.parser_logs_my_solution;

import java.nio.file.Paths;

import java.text.ParseException;

public class Solution {
    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get("example.log"));

        for (Object object : logParser.execute("get ip for user = Amigo")){
            System.out.println(object);
        }
    }
}