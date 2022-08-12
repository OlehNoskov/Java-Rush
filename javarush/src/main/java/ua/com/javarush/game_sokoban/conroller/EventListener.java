package ua.com.javarush.game_sokoban.conroller;

import ua.com.javarush.game_sokoban.model.Direction;

public interface EventListener {
    void move(Direction direction);
    void restart();
    void startNextLevel();
    void levelCompleted(int level);
}