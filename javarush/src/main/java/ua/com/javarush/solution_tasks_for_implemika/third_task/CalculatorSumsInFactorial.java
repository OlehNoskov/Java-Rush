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

    // searching factorial and return result
    public static String getFactorial(int factorial) {
        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= factorial; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return String.valueOf(result);
    }

    // searching sum of all number's digits
    public static int getSumNumbers(String number) {
        int result = 0;
        String[] numbersArray = number.split("");

        for (String n : numbersArray) {
            result += Integer.parseInt(n);
        }
        return result;
    }
}