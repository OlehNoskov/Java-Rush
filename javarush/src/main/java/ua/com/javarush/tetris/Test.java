package ua.com.javarush.tetris;

public class Test {
    static int test[][] = {
            {1, 1, 0},
            {1, 1, 1},
            {1, 0, 0}
    };

    public static void main(String[] args) {
        removeFullLines();
        for (int i = 0; i < test.length; i++) {
            for (int b = 0; b < test[i].length; b++) {
                System.out.print(test[i][b]);
            }
            System.out.println();
        }
    }

    static void removeFullLines() {
        int count = 0;
        for (int y = 0; y < test.length; y++) {
            for (int x = 0; x < test[y].length; x++) {
                if (test[y][x] == 1) {
                    count++;
                }
            }
            if (count == test.length) {
                test[y] = null;
                if (y < test.length) {
                    test[y + 1] = test[y];
                    test[y] = new int[3];
                }
            }
            count = 0;

        }
    }
}
