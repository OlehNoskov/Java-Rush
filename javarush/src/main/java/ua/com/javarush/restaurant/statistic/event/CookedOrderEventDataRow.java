package ua.com.javarush.restaurant.statistic.event;

import ua.com.javarush.restaurant.kitchen.Dish;

import java.util.Date;
import java.util.List;

public class CookedOrderEventDataRow implements EventDataRow {
    //имя планшета
    private String tabletName;
    //имя повара
    private String cookName;
    //время приготовления заказа в секундах
    private int cookingTimeSeconds;
    //список блюд для приготовления
    private List<Dish> cookingDishes;
    //текущая дата
    private Date currentDate;

    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishes) {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishes = cookingDishes;
        this.currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.COOKED_ORDER;
    }

    @Override
    public Date getDate() {
        return null;
    }

    @Override
    public int getTime() {
        return 0;
    }
}