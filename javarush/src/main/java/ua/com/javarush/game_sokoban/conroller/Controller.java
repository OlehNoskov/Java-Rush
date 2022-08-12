package ua.com.javarush.game_sokoban.conroller;

import ua.com.javarush.game_sokoban.model.Direction;
import ua.com.javarush.game_sokoban.model.GameObjects;
import ua.com.javarush.game_sokoban.model.Model;
import ua.com.javarush.game_sokoban.view.View;

public class Controller implements EventListener {
    private View view;
    private Model model;

    public Controller() {
        view = new View(this);
        model = new Model();

        view.init();
        model.restart();
    }

    public static void main(String[] args) {
        new Controller();
    }

    @Override
    public void move(Direction direction) {
        model.move(direction);
        view.update();
    }

    @Override
    public void restart() {
        model.restart();
        view.update();
    }

    @Override
    public void startNextLevel() {
        model.startNextLevel();
        view.update();
    }

    @Override
    public void levelCompleted(int level) {
        view.completed(level);
    }

    public GameObjects getGameObjects() {
        return model.getGameObjects();
    }
}