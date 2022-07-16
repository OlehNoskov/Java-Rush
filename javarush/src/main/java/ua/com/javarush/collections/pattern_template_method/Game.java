package ua.com.javarush.collections.pattern_template_method;

/** Паттерн Шаблонный метод
 * */

public abstract class Game {
    public abstract void prepareForTheGame();

    public abstract void playGame();

    public abstract void congratulateWinner();

    public void run(){
        prepareForTheGame();
        playGame();
        congratulateWinner();
    }
}