package ua.com.javarush.parser_logs;

import ua.com.javarush.parser_logs.query.IPQuery;
import ua.com.javarush.parser_logs_my_solution.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.nio.file.Path;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

public class LogParser implements IPQuery {
    private final Path logDir;
    private final int IP_INDEX = 0;
    private final int NAME_INDEX = 1;
    private final int DATE_INDEX = 2;
    private final int EVENT_INDEX = 3;
    private final int STATUS_INDEX = 4;

    private static final SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> setUniqueIPs = new TreeSet<>();
        for (String string : getAllStringsLogs()) {
            String[] array = string.split("   ");
            setUniqueIPs.add(getIP(array));
        }
        return setUniqueIPs;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> setIPsForUser = new TreeSet<>();
        for (String string : getAllStringsLogs()) {
            String[] array = string.split("   ");
            if (getName(array).equals(user)) {
                setIPsForUser.add(getIP(array));
            }
        }
        return setIPsForUser;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> setIPsForEvent = new TreeSet<>();
        for (String string : getAllStringsLogs()) {
            String[] array = string.split("   ");
            if (Objects.equals(getEvent(array), event)) {
                setIPsForEvent.add(getIP(array));
            }
        }
        return setIPsForEvent;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> setIPsForStatus = new TreeSet<>();
        for (String string : getAllStringsLogs()) {
            String[] array = string.split("   ");
            if (Objects.equals(getStatus(array), status)) {
                setIPsForStatus.add(getIP(array));
            }
        }
        return setIPsForStatus;
    }

    private List<String> getAllStringsLogs() {
        List<String> listAllStringLogs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(logDir)))) {
            while (reader.ready()) {
                listAllStringLogs.add(reader.readLine());
            }
        } catch (IOException e) {
            System.out.println("Something wrong!");
        }
        return listAllStringLogs;
    }

    private String getIP(String[] arrayString) {
        return arrayString[IP_INDEX];
    }

    private String getName(String[] arrayString) {
        return arrayString[NAME_INDEX];
    }

    private Date getDate(String string) throws ParseException {
        return simpleFormatter.parse(string);
    }

    private Event getEvent(String[] arrayString) {
        for (Event event : Event.values()){
            if (event.toString().equals(arrayString[EVENT_INDEX])){
                return event;
            }
        }
        return null;
    }

    private Status getStatus(String[] arrayString) {
        for (Status status : Status.values()){
            if (status.toString().equals(arrayString[STATUS_INDEX])){
                return status;
            }
        }
        return null;
    }
}