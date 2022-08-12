package ua.com.javarush.game_sokoban.model;

import ua.com.javarush.game_sokoban.conroller.EventListener;

public class Model {
    public static int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}