package ua.com.javarush.parser_logs_my_solution;

import java.nio.file.Paths;
import java.text.ParseException;

public class Solution {
    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get("example1.log"));
//        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        for (Logger logger : logParser.getAllLogger(logParser.getAllStringsLogs())) {
            System.out.println(logger);
        }
    }
}