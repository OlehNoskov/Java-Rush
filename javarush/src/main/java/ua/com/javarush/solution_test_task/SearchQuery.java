package ua.com.javarush.solution_test_task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;

public class SearchQuery {

    static final List<Integer> listWaitTime = new ArrayList<>();

    static void run(String pathFile) {
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
            searchEqualsQueryAndTimeline();

            for (String averageWaitingTime : Query.listAverageWaitingTime) {
                System.out.println(averageWaitingTime);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Sorry, file not found!");
        } catch (IOException e) {
            System.out.println("Sorry, some error has occurred!");
        }
    }

    private static void searchEqualsQueryAndTimeline() {
        int index = 1;
        for (Query query : Query.listValidRequest) {
            for (TimeLine timeLine : TimeLine.listValidTimeline) {
                if (isEquals(query, timeLine)) {
                    listWaitTime.add(timeLine.getWaitTime());
                }
                if (TimeLine.listValidTimeline.size() == index) {
                    Query.getResultWaitingTime();
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
                && (query.getVariation().equals(BaseQuery.EMPTY_DATA) || query.getVariation().equals(timeLine.getVariation()))
                && query.getQuestionType().equals(timeLine.getQuestionType())
                && (query.getCategory().equals(BaseQuery.EMPTY_DATA) || query.getCategory().equals(timeLine.getCategory()))
                && (query.getSubCategory().equals(BaseQuery.EMPTY_DATA) || query.getSubCategory().equals(timeLine.getSubCategory()))
                && query.getTypeAnswer().equals(timeLine.getTypeAnswer())
                && DateFromLine.isDateInSearchArea(query.getSearchDateFrom(), query.getSearchDateUpTo(), timeLine.getCreateTimeline())) {

            result = true;

        } else if (query.getQuestionType().equals(Query.SEARCH_ALL_TIMELINE)
                && query.getService().equals(timeLine.getService())
                && query.getTypeAnswer().equals(timeLine.getTypeAnswer())
                && DateFromLine.isDateInSearchArea(query.getSearchDateFrom(), query.getSearchDateUpTo(), timeLine.getCreateTimeline())) {

            result = true;
        }
        return result;
    }

    private static String getTypeQuery(String line) {
        return line.split(" ")[BaseQuery.ZERO_INDEX];
    }
}