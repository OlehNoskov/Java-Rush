package ua.com.javarush.parser_logs_my_solution;

import ua.com.javarush.parser_logs_my_solution.query.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.nio.file.Path;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
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

    /**
     * implements methods interface IPQuery
     */

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

    /**
     * implements methods interface UserQuery
     */

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

    /**
     * implements methods interface DateQuery
     */

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (Logger logger : getAllStringsLogs()) {
            if (logger.getName().equals(user)
                    && logger.getEvent().equals(event)
                    && dateBetweenDates(logger.getDate(), after, before)) {
                dates.add(logger.getDate());
            }
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (Logger logger : getAllStringsLogs()) {
            if (logger.getStatus().equals(Status.FAILED) && dateBetweenDates(logger.getDate(), after, before)) {
                dates.add(logger.getDate());
            }
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (Logger logger : getAllStringsLogs()) {
            if (logger.getStatus().equals(Status.ERROR) && dateBetweenDates(logger.getDate(), after, before)) {
                dates.add(logger.getDate());
            }
        }
        return dates;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (Logger logger : getAllStringsLogs()) {
            if (logger.getName().equals(user)
                    && logger.getEvent().equals(Event.LOGIN)
                    && dateBetweenDates(logger.getDate(), after, before)) {
                dates.add(logger.getDate());
            }
        }
        return getMinDate(dates);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (Logger logger : getAllStringsLogs()) {
            if (logger.getName().equals(user)
                    && logger.getEvent().equals(Event.SOLVE_TASK)
                    && logger.getEventAdditionalParameter == task
                    && dateBetweenDates(logger.getDate(), after, before)) {
                dates.add(logger.getDate());
            }
        }
        return getMinDate(dates);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (Logger logger : getAllStringsLogs()) {
            if (logger.getName().equals(user)
                    && logger.getEvent().equals(Event.DONE_TASK)
                    && logger.getEventAdditionalParameter == task
                    && dateBetweenDates(logger.getDate(), after, before)) {
                dates.add(logger.getDate());
            }
        }
        return getMinDate(dates);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (Logger logger : getAllStringsLogs()) {
            if (logger.getName().equals(user)
                    && logger.getEvent().equals(Event.WRITE_MESSAGE)
                    && dateBetweenDates(logger.getDate(), after, before)) {
                dates.add(logger.getDate());
            }
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (Logger logger : getAllStringsLogs()) {
            if (logger.getName().equals(user)
                    && logger.getEvent().equals(Event.DOWNLOAD_PLUGIN)
                    && dateBetweenDates(logger.getDate(), after, before)) {
                dates.add(logger.getDate());
            }
        }
        return dates;
    }

    private Date getMinDate(Set<Date> dates) {
        Date minDate = dates.iterator().next(); // Возвращает первый элемент из Set
        if (dates.size() == 0) {
            return null;
        } else {
            for (Date date : dates) {
                if (date.getTime() < minDate.getTime()) {
                    minDate = date;
                }
            }
        }
        return minDate;
    }

    /**
     * implements methods interface EventQuery
     */

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (Logger logger : getAllStringsLogs()) {
            if (dateBetweenDates(logger.getDate(), after, before)) {
                events.add(logger.getEvent());
            }
        }
        return events;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (Logger logger : getAllStringsLogs()) {
            if (logger.getIp().equals(ip) && dateBetweenDates(logger.getDate(), after, before)) {
                events.add(logger.getEvent());
            }
        }
        return events;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (Logger logger : getAllStringsLogs()) {
            if (logger.getName().equals(user) && dateBetweenDates(logger.getDate(), after, before)) {
                events.add(logger.getEvent());
            }
        }
        return events;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (Logger logger : getAllStringsLogs()) {
            if (logger.getStatus().equals(Status.FAILED) && dateBetweenDates(logger.getDate(), after, before)) {
                events.add(logger.getEvent());
            }
        }
        return events;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (Logger logger : getAllStringsLogs()) {
            if (logger.getStatus().equals(Status.ERROR) && dateBetweenDates(logger.getDate(), after, before)) {
                events.add(logger.getEvent());
            }
        }
        return events;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int quantity = 0;
        for (Logger logger : getAllStringsLogs()) {
            if (logger.getEvent().equals(Event.SOLVE_TASK)
                    && logger.getGetEventAdditionalParameter() == task
                    && dateBetweenDates(logger.getDate(), after, before)) {
                quantity++;
            }
        }
        return quantity;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int quantity = 0;
        for (Logger logger : getAllStringsLogs()) {
            if (logger.getEvent().equals(Event.DONE_TASK)
                    && logger.getGetEventAdditionalParameter() == task
                    && dateBetweenDates(logger.getDate(), after, before)) {
                quantity++;
            }
        }
        return quantity;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (Logger logger1 : getAllStringsLogs()) {
            for (Logger logger2 : getAllStringsLogs()) {
                if (logger1.getEvent().equals(Event.SOLVE_TASK)
                        && logger1.getGetEventAdditionalParameter() == logger2.getGetEventAdditionalParameter()
                        && dateBetweenDates(logger1.getDate(), after, before)) {
                    map.put(logger1.getEventAdditionalParameter, count);
                    count++;
                }
            }
            count = 1;
        }
        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (Logger logger1 : getAllStringsLogs()) {
            for (Logger logger2 : getAllStringsLogs()) {
                if (logger1.getEvent().equals(Event.DONE_TASK)
                        && logger1.getGetEventAdditionalParameter() == logger2.getGetEventAdditionalParameter()
                        && dateBetweenDates(logger1.getDate(), after, before)) {
                    map.put(logger1.getEventAdditionalParameter, count);
                    count++;
                }
            }
            count = 1;
        }
        return map;
    }

    /**
     * implements methods interface QLQuery
     */

    @Override
    public Set<Object> execute(String query) {
        Set<Object> searchAll = new HashSet<>();
        Set<Object> searchWithParameters = new HashSet<>();
        String[] arrayQuery = query.split(" ");
        String firstPartQuery = arrayQuery[0] + " " + arrayQuery[1];
        Pattern pattern = Pattern.compile("get (ip|user|date|event|status)" +
                "(for (ip|user|date|event|status) = \"(.*?)\")?");
        Matcher matcher = pattern.matcher(firstPartQuery);
        matcher.find();
        String field = matcher.group(1); //Берем значение ip|user|date|event|status

        if (arrayQuery.length == 2) {
            for (Logger logger : getAllStringsLogs()) {
                searchAll.add(getCurrentValue(logger, field));
            }
            return searchAll;
        } else {
            String field1 = arrayQuery[1];
            String field2 = arrayQuery[3];
            String value = query.split("=")[1].trim();

            for (Logger logger : getAllStringsLogs()) {
                if (getCurrentValue(logger, field2).toString().equals(value)) {
                    searchWithParameters.add(getCurrentValue(logger, field1));
                } else if (field2.equals("date")) {
                    try {
                        Date date = simpleFormatter.parse(value);
                        if (getCurrentValue(logger, field2).equals(date)) {
                            searchWithParameters.add(getCurrentValue(logger, field1));
                        }
                    } catch (ParseException e) {
                        e.getMessage();
                    }
                }
            }
            return searchWithParameters;
        }
    }

    private Object getCurrentValue(Logger logEntity, String field) {
        Object value = null;
        switch (field) {
            case "ip" -> {
                Command method = new GetIpCommand(logEntity);
                value = method.execute();
            }
            case "user" -> {
                Command method = new GetUserCommand(logEntity);
                value = method.execute();
            }
            case "date" -> {
                Command method = new GetDateCommand(logEntity);
                value = method.execute();
            }
            case "event" -> {
                Command method = new GetEventCommand(logEntity);
                value = method.execute();
            }
            case "status" -> {
                Command method = new GetStatusCommand(logEntity);
                value = method.execute();
            }
        }
        return value;
    }

    /**
     * inner class Command
     */

    private abstract class Command {
        protected Logger logger;

        abstract Object execute();
    }

    private class GetIpCommand extends Command {
        public GetIpCommand(Logger logger) {
            this.logger = logger;
        }

        @Override
        Object execute() {
            return logger.getIp();
        }
    }

    private class GetUserCommand extends Command {
        public GetUserCommand(Logger logger) {
            this.logger = logger;
        }

        @Override
        Object execute() {
            return logger.getName();
        }
    }

    private class GetDateCommand extends Command {
        public GetDateCommand(Logger logger) {
            this.logger = logger;
        }

        @Override
        Object execute() {
            return logger.getDate();
        }
    }

    private class GetEventCommand extends Command {
        public GetEventCommand(Logger logger) {
            this.logger = logger;
        }

        @Override
        Object execute() {
            return logger.getEvent();
        }
    }

    private class GetStatusCommand extends Command {
        public GetStatusCommand(Logger logger) {
            this.logger = logger;
        }

        @Override
        Object execute() {
            return logger.getStatus();
        }
    }

    /**
     * inner class Logger
     */

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