package ua.com.javarush.solution_tasks_for_implemika.first_task;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleh Noskov.
 */

public class Solution {
    private static final String openBracket = "(";
    private static final String closedBracket = ")";
    private static final String INPUT_FILE = "inputDataFirstTask.txt";

    public static List<String[]> listArraysFromFile = new ArrayList<>();
    public static List<Integer> listCountValidExpressions = new ArrayList<>();

    private static final int FIRST_INDEX_BRACKET = 0;

    public static void run() {
        int result = 0;
        System.out.print("Enter number: ");

        addArrayToListFromFile();
        addCountExpressions();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(bufferedReader.readLine());

            for (Integer integer : listCountValidExpressions) {
                if (integer == number) {
                    result++;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Input data is not number!");
        } catch (IOException e) {
            System.out.println("Something wrong!");
        }
        System.out.println("Answer: " + result);
    }

    // validation input string
    private static boolean isCorrectExpression(String[] string) {
        return string[FIRST_INDEX_BRACKET].equals(openBracket) && string[string.length - 1].equals(closedBracket);
    }

    private static boolean isEqualsCountBracket(int openBracketCount, int closedBracketCount) {
        return openBracketCount == closedBracketCount;
    }

    private static void addArrayToListFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE))) {
            while (reader.ready()) {
                String[] stringArray = reader.readLine().split("");
                listArraysFromFile.add(stringArray);
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found!");
        }
    }

    private static void addCountExpressions() {
        int countOpenBracket = 0;
        int countClosedBracket = 0;

        for (String[] stringArray : listArraysFromFile) {
            if (isCorrectExpression(stringArray)) {

                for (String s : stringArray) {
                    if (s.equals(openBracket)) {
                        countOpenBracket++;
                    } else if (s.equals(closedBracket)) {
                        countClosedBracket++;
                    }
                }
            }
            if (isEqualsCountBracket(countOpenBracket, countClosedBracket)) {
                if (countOpenBracket != 0) {
                    listCountValidExpressions.add(countOpenBracket);
                    countOpenBracket = 0;
                    countClosedBracket = 0;
                }
            }
        }
    }

}