package ua.com.javarush.other;

public class FirstSolution {
    public static void main(String[] args) {
        FirstSolution solution = new FirstSolution();
        int number = Integer.MAX_VALUE - 133;
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
        number = number | (number >> 1);
        number = number | (number >> 2);
        number = number | (number >> 4);
        number = number | (number >> 8);
        number = number | (number >> 16);
        return (number & ~(number >> 1));
    }
}