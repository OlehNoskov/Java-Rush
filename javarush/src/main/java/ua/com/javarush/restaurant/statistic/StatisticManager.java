package ua.com.javarush.restaurant.statistic;

import ua.com.javarush.restaurant.kitchen.Cook;
import ua.com.javarush.restaurant.statistic.event.EventDataRow;
import ua.com.javarush.restaurant.statistic.event.EventType;

import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private Set<Cook> cooks = new HashSet<>();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        this.statisticStorage.put(data);
    }

    public void register(Cook cook) {
        this.cooks.add(cook);
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        private StatisticStorage() {
            for (EventType type : EventType.values()) {
                this.storage.put(type, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            EventType type = data.getType();
            if (!this.storage.containsKey(type))
                throw new UnsupportedOperationException();
            this.storage.get(type).add(data);
        }
    }
}