package ua.com.javarush.game_sokoban.conroller;

import ua.com.javarush.game_sokoban.model.Direction;
import ua.com.javarush.game_sokoban.model.Model;
import ua.com.javarush.game_sokoban.view.View;

public class Controller implements EventListener {
    private View view;
    private Model model;

    public Controller() {
        view = new View(this);
        model = new Model();
        view.init();
    }

    public static void main(String[] args) {
        new Controller();
    }

    @Override
    public void move(Direction direction) {

    }

    @Override
    public void restart() {

    }

    @Override
    public void startNextLevel() {

    }

    @Override
    public void levelCompleted(int level) {

    }
}