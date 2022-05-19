package ua.com.javarush.solution_test_task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.text.ParseException;
import java.util.*;

public class SearchQuery {

    private static final List<String> listValidRequest = new ArrayList<>();
    private static final List<String> listValidWaitTimeline = new ArrayList<>();
    private static final List<Integer> listWaitTime = new ArrayList<>();

    public void addValidRequestsAndWaitTimeline(String pathFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))) {
            String line = reader.readLine();

            while (line != null) {
                if (Query.isQuery(line)) {
                    if (Query.isQuery(line)) {
                        listValidRequest.add(line);
                    }
                }
                if (WaitTime.isWaitTimeline(line)) {
                    listValidWaitTimeline.add(line);
                }
                line = reader.readLine();
            }
            printOutputResult();

//          for (int i: listWaitTime){
//              System.out.println(i);
//          }

        } catch (FileNotFoundException e) {
            System.out.println("Sorry, file not found!");
        } catch (IOException | ParseException e) {
            System.out.println("Sorry, some error has occurred!");
        }
    }

    public void printOutputResult() throws ParseException {
        List<Integer> minutes = new ArrayList<>();
        int index = 0;

        for (String s : listValidRequest) {
            for (String s2 : listValidWaitTimeline) {
                index++;
                if (ComparisonServiceIdVariationId.isServiceIdEquals
                        (QueryStringData.getNumberServiceId(s), QueryStringData.getNumberServiceId(s2))) {

                    if (QueryStringData.getNumberVariationId(s) == 0
                            || ComparisonServiceIdVariationId.isVariationIdEquals(QueryStringData.getNumberVariationId(s),
                            QueryStringData.getNumberVariationId(s2))) {

                        if(!QueryStringData.getQuestionTypeCategorySubCategory(s).equals(QueryStringData.getAllSearch())) {

                            if (ComparisonQuestionCategorySubCategory.isQuestionType(QueryStringData.getNumberQuestionType(s)
                                    , QueryStringData.getNumberQuestionType(s2))) {

                                if (QueryStringData.getNumberCategory(s) == 0 ||
                                        ComparisonQuestionCategorySubCategory.
                                                isCategoryEquals(QueryStringData.getNumberCategory(s), QueryStringData.getNumberCategory(s2))) {

                                    if (QueryStringData.getNumberSubCategory(s) == 0 ||
                                            ComparisonQuestionCategorySubCategory.isSubCategoryIdEquals(QueryStringData.getNumberSubCategory(s), QueryStringData.getNumberSubCategory(s2))) {
                                        minutes.add(WaitTime.getWaitingTime(s2));
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (index == listValidWaitTimeline.size() && minutes.size()!=0) {
                        listWaitTime.add(WaitTime.getResultWaitingTime(minutes));
                        minutes.clear();
                        index = 0;
                    }
                }
            }
        }
    }
}