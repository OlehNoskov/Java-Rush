package ua.com.javarush.parser_logs;

import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get("example.log"));
        logParser.getUniqueIPs(new Date(), new Date());
    }
}