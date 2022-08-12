package ua.com.javarush.game_sokoban.view;

import ua.com.javarush.game_sokoban.conroller.Controller;
import ua.com.javarush.game_sokoban.conroller.EventListener;

import javax.swing.*;

public class View extends JFrame {
    private Controller controller;
    private Field field;

    public View(Controller controller) {
        this.controller = controller;
    }

   public void setEventListener(EventListener eventListener){
        field.setEventListener(eventListener);
    }

    public void init() {
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Сокобан");
        setVisible(true);
    }
}