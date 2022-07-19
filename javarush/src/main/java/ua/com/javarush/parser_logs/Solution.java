package ua.com.javarush.parser_logs;

import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get("example.log"));
        System.out.println(logParser.getNumberOfUniqueIPs(new Date(),new Date()));
        System.out.println("=======================================");

        for (String string : logParser.getUniqueIPs(new Date(), new Date())){
            System.out.println(string);
        }
        System.out.println("=======================================");

        for (String string : logParser.getIPsForUser("Amigo", new Date(), new Date())){
            System.out.println(string);
        }
        System.out.println("=======================================");

        for (String string : logParser.getIPsForEvent(Event.DONE_TASK ,new Date(), new Date())){
            System.out.println(string);
        }
        System.out.println("=======================================");

        for (String string : logParser.getIPsForStatus(Status.OK,new Date(), new Date())){
            System.out.println(string);
        }
    }
}