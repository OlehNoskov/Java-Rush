package ua.com.javarush.restaurant.statistic.event;

import java.util.Date;

public class NoAvailableVideoEventDataRow implements EventDataRow {
    //время приготовления заказа в секундах
    private int totalDuration;
    //текущая дата
    private Date currentDate;

    public NoAvailableVideoEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.NO_AVAILABLE_VIDEO;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    //общее время приготовления заказа
    @Override
    public int getTime() {
        return totalDuration;
    }
}