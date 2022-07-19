package ua.com.javarush.parser_logs;

import ua.com.javarush.parser_logs.query.IPQuery;
import ua.com.javarush.parser_logs_my_solution.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.nio.file.Path;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
        return 0;
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) throws ParseException {
        String string = getAllStringsLogs().get(3);
        String[] array = string.split("   ");
        String ip = array[IP_INDEX];
        String name = array[NAME_INDEX];
        Date date = getDate(array[DATE_INDEX]);
        String event = array[EVENT_INDEX];
        String status = array[STATUS_INDEX];
        System.out.println(ip + " " + name + " " + date + " "+ event + " " + status);
        return null;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return null;
    }

    public List<String> getAllStringsLogs() {
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

    public Date getDate(String string) throws ParseException {
        return simpleFormatter.parse(string);
    }
}