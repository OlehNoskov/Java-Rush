package ua.com.javarush.solution_test_task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class SearchQuery {

    static final List<String> listValidRequest = new ArrayList<>();
//    private static final List<Integer> listWaitTime = new ArrayList<>();

    public void addValidRequestsAndWaitTimeline(String pathFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))) {
            String line = reader.readLine();

            while (line != null) {
                if (Query.SYMBOL_QUERY.equals(isValidString(line))) {
                    Query.parsingString(line);

                }
                if (TimeLine.SYMBOL_QUERY.equals(isValidString(line))) {
                    TimeLine.parsingString(line);
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, file not found!");
        } catch (IOException e) {
            System.out.println("Sorry, some error has occurred!");
        }
    }

    private static String isValidString(String line) {
        return line.split(" ")[0];
    }
}