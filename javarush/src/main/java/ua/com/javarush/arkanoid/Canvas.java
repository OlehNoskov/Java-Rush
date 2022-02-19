package ua.com.javarush.arkanoid;

public class Canvas {

    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height + 2][width + 2];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Ставим одну точку на холсте с координатами (x,y) и цветом - c.
     */
    void setPoint(double x, double y, char c) {
        int pointX = (int) Math.round(x);
        int pointY = (int) Math.round(y);

        if (pointX > 0 && pointY > 0 && pointY <= matrix.length && pointX <= matrix[0].length) {
            this.matrix[pointY][pointX] = c;
        }
    }

    /**
     * Печатаем переданную фигуру в указанных координатах цветом c.
     * Если переданный массив содержит единицы, то на холсте им будут соответствовать символы - с.
     */
    void drawMatrix(double x, double y, int[][] matrix, char c) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }

    void print() {
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                System.out.print(" ");
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }

            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public void clear() {
        this.matrix = new char[height + 2][width + 2];
    }
}