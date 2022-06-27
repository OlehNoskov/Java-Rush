package ua.com.javarush.solution_tasks_for_implemika.first_task;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class ExpressionsCounter {
    private static final String OPEN_BRACKET = "(";
    private static final String CLOSED_BRACKET = ")";
    private static final String INPUT_FILE = "inputDataFirstTask.txt";

    // list valid lines from file converted to Array String
    public static List<String[]> listArraysFromFile = new ArrayList<>();
    // list count valid expressions for search
    public static List<Integer> listCountValidExpressions = new ArrayList<>();
    // number index first element in array
    private static final int FIRST_INDEX_BRACKET = 0;

    // starting program and showing result
    public static void run() {
        int result = 0;
        System.out.print("Enter number: ");

        addValidStringToListFromFile();
        addCountExpressions();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(bufferedReader.readLine());

            for (Integer integer : listCountValidExpressions) {
                if (number == integer) {
                    result++;
                }
            }
            System.out.println("Answer:" + result);

        } catch (NumberFormatException e) {
            System.out.println("Input data is not number! Restart this program!");
        } catch (IOException e) {
            System.out.println("Something wrong!");
        }
    }

    // validation input string
    private static boolean isCorrectExpression(String[] string) {
        return string[FIRST_INDEX_BRACKET].equals(OPEN_BRACKET) && string[string.length - 1].equals(CLOSED_BRACKET);
    }

    // checking amounts open and closed brackets
    private static boolean isEqualsCountBracket(int counterOpenBracket, int counterClosedBracket) {
        return counterOpenBracket == counterClosedBracket;
    }

    // reading from file and adding all valid string from file to list
    private static void addValidStringToListFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE))) {
            while (reader.ready()) {
                String[] string = reader.readLine().split("");

                if (isCorrectExpression(string)) {
                    listArraysFromFile.add(string);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found!");
        }
    }

    //adding all brackets counters
    private static void addCountExpressions() {
        int counterOpenBracket = 0;
        int counterClosedBracket = 0;

        for (String[] string : listArraysFromFile) {
            for (String symbol : string) {

                if (symbol.equals(OPEN_BRACKET)) {
                    counterOpenBracket++;
                } else if (symbol.equals(CLOSED_BRACKET)) {
                    counterClosedBracket++;
                }
            }
            if (isEqualsCountBracket(counterOpenBracket, counterClosedBracket)) {
                listCountValidExpressions.add(counterOpenBracket);
                //reset counter
                counterOpenBracket = 0;
                counterClosedBracket = 0;
            }
        }
    }
}