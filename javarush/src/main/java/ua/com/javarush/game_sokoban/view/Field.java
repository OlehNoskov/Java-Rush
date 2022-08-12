package ua.com.javarush.game_sokoban.view;

import ua.com.javarush.game_sokoban.conroller.EventListener;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    View view;
    private EventListener eventListener;

    public Field(View view) {
        this.view = view;
    }

    @Override
    public void paint(Graphics graphics) {

    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}