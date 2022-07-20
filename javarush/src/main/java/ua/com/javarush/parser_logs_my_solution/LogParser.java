package ua.com.javarush.parser_logs_my_solution;

import ua.com.javarush.parser_logs_my_solution.query.IPQuery;
import ua.com.javarush.parser_logs_my_solution.query.UserQuery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.nio.file.Path;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;

public class LogParser implements IPQuery, UserQuery {
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
        for (Logger logger : getAllStringsLogs()) {
            if (dateBetweenDates(logger.getDate(), after, before)) {
                setUniqueIPs.add(logger.getIp());
            }
        }
        return setUniqueIPs;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> setIPsForUser = new TreeSet<>();
        for (Logger logger : getAllStringsLogs()) {
            if (logger.getName().equals(user) && dateBetweenDates(logger.getDate(), after, before)) {
                setIPsForUser.add(logger.getIp());
            }
        }
        return setIPsForUser;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> setIPsForEvent = new TreeSet<>();
        for (Logger logger : getAllStringsLogs()) {
            if (logger.getEvent().equals(event) && dateBetweenDates(logger.getDate(), after, before)) {
                setIPsForEvent.add(logger.getIp());
            }
        }
        return setIPsForEvent;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> setIPsForStatus = new TreeSet<>();
        for (Logger logger : getAllStringsLogs()) {
            if (logger.getStatus().equals(status) && dateBetweenDates(logger.getDate(), after, before)) {
                setIPsForStatus.add(logger.getIp());
            }
        }
        return setIPsForStatus;
    }

    private List<Logger> getAllStringsLogs() {
        List<Logger> listAllLogger = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(logDir)))) {
            while (reader.ready()) {
                listAllLogger.add(createNewLogger(reader.readLine()));
            }
        } catch (IOException | ParseException e) {
            System.out.println("Something wrong!");
        }
        return listAllLogger;
    }

    private Logger createNewLogger(String string) throws ParseException {
        String[] array = string.split("   ");
        return new Logger((getIP(array)), getName(array), getDate(array),
                getEvent(array), getNumberTask(string), getStatus(array));
    }

    private String getIP(String[] arrayString) {
        return arrayString[IP_INDEX];
    }

    private String getName(String[] arrayString) {
        return arrayString[NAME_INDEX];
    }

    private Date getDate(String[] string) throws ParseException {
        return simpleFormatter.parse(string[DATE_INDEX]);
    }

    private Event getEvent(String[] arrayString) {
        for (Event event : Event.values()) {
            if (arrayString[EVENT_INDEX].split(" ").length == 2) {
                if (event.toString().equals(arrayString[EVENT_INDEX].split(" ")[0])) {
                    return event;
                }
            } else {
                if (event.toString().equals(arrayString[EVENT_INDEX])) {
                    return event;
                }
            }
        }
        return null;
    }

    private int getNumberTask(String string) {
        int numberTask = 0;
        String[] array = string.split("   ");
        if (array[EVENT_INDEX].split(" ").length == 2) {
            numberTask = Integer.parseInt(array[EVENT_INDEX].split(" ")[1]);
        }
        return numberTask;
    }

    private Status getStatus(String[] arrayString) {
        for (Status status : Status.values()) {
            if (status.toString().equals(arrayString[STATUS_INDEX])) {
                return status;
            }
        }
        return null;
    }

    private boolean dateBetweenDates(Date current, Date after, Date before) {
        return current.after(after) && current.before(before);
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> setAllUsers = new HashSet<>();
        for (Logger logger : getAllStringsLogs()) {
            setAllUsers.add(logger.getName());
        }
        return setAllUsers;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> setAllUsers = new HashSet<>();
        for (Logger logger : getAllStringsLogs()) {
            if (dateBetweenDates(logger.getDate(), after, before)) {
                setAllUsers.add(logger.getName());
            }
        }
        return setAllUsers.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> setUserEvents = new HashSet<>();

        for (Logger logger : getAllStringsLogs()) {
            if (logger.getName().equals(user) && dateBetweenDates(logger.getDate(), after, before)) {
                   setUserEvents.add(logger.getEvent());
            }
        }
        return setUserEvents.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> setUsers = new HashSet<>();

        for (Logger logger : getAllStringsLogs()) {
            if (logger.getIp().equals(ip) && dateBetweenDates(logger.getDate(), after, before)) {
                setUsers.add(logger.getName());
            }
        }
        return setUsers;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> setUsers = new HashSet<>();

        for (Logger logger : getAllStringsLogs()) {
            if (logger.getEvent().equals(Event.LOGIN) && dateBetweenDates(logger.getDate(), after, before)) {
                setUsers.add(logger.getName());
            }
        }
        return setUsers;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> setUsers = new HashSet<>();

        for (Logger logger : getAllStringsLogs()) {
            if (logger.getEvent().equals(Event.DOWNLOAD_PLUGIN) && dateBetweenDates(logger.getDate(), after, before)) {
                setUsers.add(logger.getName());
            }
        }
        return setUsers;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> setUsers = new HashSet<>();

        for (Logger logger : getAllStringsLogs()) {
            if (logger.getEvent().equals(Event.WRITE_MESSAGE) && dateBetweenDates(logger.getDate(), after, before)) {
                setUsers.add(logger.getName());
            }
        }
        return setUsers;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> setUsers = new HashSet<>();

        for (Logger logger : getAllStringsLogs()) {
            if (logger.getEvent().equals(Event.SOLVE_TASK) && dateBetweenDates(logger.getDate(), after, before)) {
                setUsers.add(logger.getName());
            }
        }
        return setUsers;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> setUsers = new HashSet<>();

        for (Logger logger : getAllStringsLogs()) {
            if (logger.getEvent().equals(Event.SOLVE_TASK)
                    && dateBetweenDates(logger.getDate(), after, before)
                    && logger.getGetEventAdditionalParameter() == task) {
                setUsers.add(logger.getName());
            }
        }
        return setUsers;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> setUsers = new HashSet<>();

        for (Logger logger : getAllStringsLogs()) {
            if (logger.getEvent().equals(Event.DONE_TASK)
                    && dateBetweenDates(logger.getDate(), after, before)) {
                setUsers.add(logger.getName());
            }
        }
        return setUsers;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> setUsers = new HashSet<>();

        for (Logger logger : getAllStringsLogs()) {
            if (logger.getEvent().equals(Event.DONE_TASK)
                    && dateBetweenDates(logger.getDate(), after, before)
                    && logger.getGetEventAdditionalParameter() == task) {
                setUsers.add(logger.getName());
            }
        }
        return setUsers;
    }

    private static class Logger {
        private String ip;
        private String name;
        private Date date;
        private Event event;
        private int getEventAdditionalParameter;
        private Status status;

        public Logger(String ip, String name, Date date, Event event, int getEventAdditionalParameter, Status status) {
            this.ip = ip;
            this.name = name;
            this.date = date;
            this.event = event;
            this.getEventAdditionalParameter = getEventAdditionalParameter;
            this.status = status;
        }

        public String getIp() {
            return ip;
        }

        public String getName() {
            return name;
        }

        public Date getDate() {
            return date;
        }

        public Event getEvent() {
            return event;
        }

        public void setEvent(Event event) {
            this.event = event;
        }

        public Status getStatus() {
            return status;
        }

        public int getGetEventAdditionalParameter() {
            return getEventAdditionalParameter;
        }
    }
}