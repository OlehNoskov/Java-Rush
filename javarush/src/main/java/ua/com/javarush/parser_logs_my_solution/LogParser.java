package ua.com.javarush.parser_logs_my_solution;

import ua.com.javarush.parser_logs_my_solution.query.IPQuery;

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
    private final int TIME_INDEX = 3;
    private final int EVENT_INDEX = 4;
    private final int NUMBER_TASK_INDEX = 5;
    private final int STATUS_INDEX = 6;

    private static final SimpleDateFormat simpleFormatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return 0;
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
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

    public List<Logger> getAllLogger(List<String> allStringLogs) throws ParseException {
        List<Logger> allLoggers = new ArrayList<>();
        for (String string : allStringLogs) {
            String[] arrayString = string.split("   ");
//            String date = arrayString[DATE_INDEX] + " " + arrayString[TIME_INDEX];
            String date = arrayString[DATE_INDEX] + " " + arrayString[TIME_INDEX];
            int numberTask = 0;
            if (arrayString.length == 6) {
                numberTask = Integer.parseInt(arrayString[NUMBER_TASK_INDEX]);
            }

            allLoggers.add(new Logger(arrayString[0], arrayString[1],
                    getDate(date),arrayString[4], numberTask, arrayString[5].split("    ")[1]));
        }
        return allLoggers;
    }

    public Date getDate(String string) throws ParseException {
        return simpleFormatter.parse(string);
    }
}