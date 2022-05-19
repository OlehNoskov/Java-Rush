package ua.com.javarush.solution_test_task;

import java.text.ParseException;

public class Solution {
//    private static final String fileNameInputData = "input.txt";
    private static final String fileNameInputData = "C:\\Users\\Олег и Ирина\\IdeaProjects\\Java Rush\\javarush\\src\\main\\java\\ua\\com\\javarush\\solution_test_task\\input.txt";

    public static void main(String[] args) throws ParseException {
        SearchQuery searchQuery = new SearchQuery();
        searchQuery.addValidRequestsAndWaitTimeline(fileNameInputData);
        String s     = "C 3 10.2 N 10.10.2012 100";
        String[] s2 = s.split(" ");


//        System.out.println(DateFromLine.getDateStartQuery("10.10.2020").before(DateFromLine.getDateEndQuery("10.12.2020")));
        System.out.println( DateFromLine.getDateCreateWaitTimeDate(s));
        System.out.println( DateFromLine.getDateEndQuery("C 3 10.2 N 02.10.2012 100"));

//        DateFromLine.getDateStartQuery("10.10.2020").before(DateFromLine.getDateEndQuery("10.12.2020"));
    }
}