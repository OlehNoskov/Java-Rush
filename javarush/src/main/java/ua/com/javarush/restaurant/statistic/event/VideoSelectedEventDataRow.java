package ua.com.javarush.restaurant.statistic.event;

import ua.com.javarush.restaurant.ad.Advertisement;

import java.util.Date;
import java.util.List;

public class VideoSelectedEventDataRow implements EventDataRow {
    //список видеороликов, отобранных для заказа
    private List<Advertisement> optimalVideoSet;
    //сумма денег за просмотр в копейках
    private long amount;
    //общая продолжительность показа отобранных рекламных роликов
    private int totalDuration;
    //текущая дата
    private Date currentDate;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    //общая продолжительность показа отобранных рекламных роликов
    @Override
    public int getTime() {
        return totalDuration;
    }

    public long getAmount() {
        return amount;
    }
}