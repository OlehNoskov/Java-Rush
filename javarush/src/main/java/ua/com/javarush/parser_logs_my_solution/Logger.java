package ua.com.javarush.parser_logs_my_solution;

import java.util.Date;

public class Logger {

    private String ip;
    private String name;
    private Date date;
    private String event;
    private int numberTask;
    private String status;

    public Logger(String ip, String name, Date date, String event, int numberTask, String status) {
        this.ip = ip;
        this.name = name;
        this.date = date;
        this.event = event;
        this.numberTask = numberTask;
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public int getNumberTask() {
        return numberTask;
    }

    public void setNumberTask(int numberTask) {
        this.numberTask = numberTask;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Logger{" +
                "ip='" + ip + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", event='" + event + '\'' +
                ", numberTask=" + numberTask +
                ", status='" + status + '\'' +
                '}';
    }
}