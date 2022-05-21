package ua.com.javarush.solution_test_task;

import java.text.ParseException;

public class Solution {
//    private static final String fileNameInputData = "input.txt";
    private static final String fileNameInputData = "C:\\Users\\Олег и Ирина\\IdeaProjects\\Java Rush\\javarush\\src\\main\\java\\ua\\com\\javarush\\solution_test_task\\input.txt";

    public static void main(String[] args) throws ParseException {
        SearchQuery searchQuery = new SearchQuery();
        searchQuery.addValidRequestsAndWaitTimeline(fileNameInputData);

        for (Query query : Query.listValidRequest){
            System.out.println(query);
        }

//        String test = "C 1.1 8.15.1 P 15.10.2012 83";
//        Query query = new Query();
//
//        for (String s:  query.getLineArray(test)){
//            System.out.println(s);
//        }
    }
}