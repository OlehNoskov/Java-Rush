package ua.com.javarush.restaurant.statistic.event;

import java.util.Date;

public interface EventDataRow {
    EventType getType();
    //Дата создания записи события
    Date getDate();
    int getTime();
}