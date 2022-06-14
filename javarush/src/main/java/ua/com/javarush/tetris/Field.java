package ua.com.javarush.tetris;

//отвечает за хранение данных о текущих занятых и свободных клетках на поле игры
public class Field {
    private int width;
    private int height;
    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    //отрисовка текущего состояния
    void print() {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                if (matrix[y][x] == 0)
                    System.out.print(".");
                else
                    System.out.print("X");
            }
            System.out.println();
        }
    }

    //удаление из матирицы полностью заполненных строк
    void removeFullLines() {
        int count = 0;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                if (matrix[y][x] == 1) {
                    count++;
                }
            }
                if (count == matrix.length) {
                    matrix[y] = null;
                    matrix[y + 1] = matrix[y];
                    matrix[y] = new int[width];
                }
                count = 0;
        }
    }

    //возвращает разницу между кооринатами x and y
    Integer getValue(int x, int y) {
        return null;
    }

    //устанавливает переданное значение в ячейку массива matrix
    void setValue(int x, int y, int value) {

    }
}