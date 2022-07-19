package ua.com.javarush.parser_logs.query;

import ua.com.javarush.parser_logs.Event;
import ua.com.javarush.parser_logs.Status;

import java.text.ParseException;
import java.util.Date;
import java.util.Set;

public interface IPQuery {
    int getNumberOfUniqueIPs(Date after, Date before) throws ParseException;

    Set<String> getUniqueIPs(Date after, Date before) throws ParseException;

    Set<String> getIPsForUser(String user, Date after, Date before) throws ParseException;

    Set<String> getIPsForEvent(Event event, Date after, Date before) throws ParseException;

    Set<String> getIPsForStatus(Status status, Date after, Date before) throws ParseException;
}