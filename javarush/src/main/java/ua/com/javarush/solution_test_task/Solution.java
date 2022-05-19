package ua.com.javarush.solution_test_task;

import java.util.Arrays;

public class Solution {
//    private static final String fileNameInputData = "input.txt";
    private static final String fileNameInputData = "C:\\Users\\Олег и Ирина\\IdeaProjects\\Java Rush\\javarush\\src\\main\\java\\ua\\com\\javarush\\solution_test_task\\input.txt";

    public static void main(String[] args) {
        SearchQuery searchQuery = new SearchQuery();
        searchQuery.addValidRequestsAndWaitTimeline(fileNameInputData);

        String s    ="C 1.10 5 P 01.11.2012 117";
        System.out.println(Arrays.toString(QueryStringData.getLineArray(s)));
        System.out.println(QueryStringData.getTypeQuery(s));
        System.out.println(QueryStringData.getNumberServiceId(s));
        System.out.println(QueryStringData.getNumberVariationId(s));
        System.out.println(QueryStringData.getNumberQuestionType(s));
        System.out.println(QueryStringData.getNumberCategory(s));
        System.out.println(QueryStringData.getNumberSubCategory(s));


    }
}