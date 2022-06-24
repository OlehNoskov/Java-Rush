package ua.com.javarush.solution_tasks_for_implemika.third_task;

import java.math.BigInteger;

/**
 * Created by Oleh Noskov.
 */

public class CalculatorSumsInFactorial {
    //default number
    private static final int INPUT_NUMBER = 100;

    public static void main(String[] args) {
        System.out.println(getSumNumbers(getFactorial(INPUT_NUMBER)));
    }

    // search factorial and return String
    public static String getFactorial(int factorial) {
        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= factorial; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result.toString();
    }

    // search sum digits in number
    public static int getSumNumbers(String number) {
        int result = 0;
        String[] array = number.split("");

        for (String s : array) {
            result += Integer.parseInt(s);
        }
        return result;
    }
}