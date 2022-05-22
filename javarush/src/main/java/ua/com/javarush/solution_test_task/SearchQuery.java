package ua.com.javarush.solution_test_task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class SearchQuery {

    static final List<Integer> listWaitTime = new ArrayList<>();

    public static void addValidRequestsAndWaitTimeline(String pathFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))) {
            String line = reader.readLine();

            while (line != null) {
                if (Query.SYMBOL_QUERY.equals(getTypeQuery(line))) {
                    Query.parsingString(line);
                }
                if (TimeLine.SYMBOL_QUERY.equals(getTypeQuery(line))) {
                    TimeLine.parsingString(line);
                }
                line = reader.readLine();
            }
            equalsQueryAndTimeline();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, file not found!");
        } catch (IOException e) {
            System.out.println("Sorry, some error has occurred!");
        }
    }

    public static void equalsQueryAndTimeline() {
        int index = 1;
        for (Query query : Query.listValidRequest) {
            for (TimeLine timeLine : TimeLine.listValidWaitTimeline) {
                if (isEquals(query, timeLine)) {

                    listWaitTime.add(timeLine.getWaitTime());
                }
                if (TimeLine.listValidWaitTimeline.size() == index) {
                    Query.resultWaitingTime();
                    listWaitTime.clear();
                    index = 0;
                }
                index++;
            }
        }
    }

    private static boolean isEquals(Query query, TimeLine timeLine) {
        boolean result = false;
        if (query.getService().equals(timeLine.getService())
                && (query.getVariation().equals("") || query.getVariation().equals(timeLine.getVariation()))
                && query.getQuestionType().equals(timeLine.getQuestionType())
                && (query.getCategory().equals("") || query.getCategory().equals(timeLine.getCategory()))
                && (query.getSubCategory().equals("") || query.getSubCategory().equals(timeLine.getSubCategory()))
                && query.getTypeAnswer().equals(timeLine.getTypeAnswer())
                && DateFromLine.isValidDate(query.getSearchDateFrom(), query.getSearchDateUpTo(), timeLine.getCreateTimeline())) {
            result = true;
        }
        return result;
    }

    private static String getTypeQuery(String line) {
        return line.split(" ")[0];
    }
}