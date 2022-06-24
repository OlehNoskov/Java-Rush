package ua.com.javarush.solution_tasks_for_implemika.first_task;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static final String openBracket = "(";
    private static final String closedBracket = ")";

    private static final String INPUT_FILE = "inputDataFirstTask.txt";

    private static final List<String[]> arrayList = new ArrayList<>();
    public static final List<Integer> countValid = new ArrayList<>();

    private static final int FIRST_INDEX_BRACKET = 0;

    public static void run() {
        add();
        System.out.print("Entered number:");
        int count = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                int number = Integer.parseInt(bufferedReader.readLine());

                for (Integer integer : countValid) {
                    if (integer == number) {
                        count++;
                    }
                }
        }
        catch (NumberFormatException e) {
            System.out.println("Input data is not number!");
        }
        catch (IOException e) {
            System.out.println("Something wrong!");
        }
        System.out.print("Answer:"+ count);
    }

    // validation input string
    private static boolean isCorrectString(String[] string) {
        return string[FIRST_INDEX_BRACKET].equals(openBracket) && string[string.length - 1].equals(closedBracket);
    }

    private static boolean isEqualsCountBracket(int firstCount, int secondCount) {
        return firstCount == secondCount;
    }

    private static void addArrayToListFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE))) {

            while (reader.ready()) {
                String[] stringArray = reader.readLine().split("");
                arrayList.add(stringArray);
            }
        } catch (
                IOException e) {
            throw new RuntimeException("File not found!");
        }
    }

    public static void add() {
        int countOpenBracket = 0;
        int countClosedBracket = 0;

        addArrayToListFromFile();

        for (String[] stringArray : arrayList) {

            if (isCorrectString(stringArray)) {
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
                    countValid.add(countOpenBracket);
                }
                countOpenBracket = 0;
                countClosedBracket = 0;
            }
        }
    }
}