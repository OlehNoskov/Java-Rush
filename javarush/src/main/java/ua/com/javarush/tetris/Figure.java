package ua.com.javarush.tetris;

//Класс, описывающий падающую фигуру 1-клетка есть, 0 - нет
public class Figure {
    private int x;
    private int y;
    private int[][] matrix;

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    void left(){

    }

    void right(){

    }

    void down(){

    }

    void up(){

    }

    //поворот фигуры
    void rotate(){

    }

    //падение фигуры вниз до дна
    void downMaximum(){

    }

    //проверка, может ли фигура помещена в текущую позицию
    boolean isCurrentPositionAvailable(){
        return true;
    }

    //вызывается, когда фигура достигла дна и уперлась
    void landed(){

    }
}