package ua.com.javarush.solution_test_task;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

public class Solution {
//    private static final String fileNameInputData = "input.txt";
    private static final String fileNameInputData = "C:\\Users\\Олег и Ирина\\IdeaProjects\\Java Rush\\javarush\\src\\main\\java\\ua\\com\\javarush\\solution_test_task\\input.txt";

    public static void main(String[] args) throws ParseException {
        SearchQuery searchQuery = new SearchQuery();
        searchQuery.addValidRequestsAndWaitTimeline(fileNameInputData);

        String s    ="D 1.10. 5 N 01.11.2012-10.10.2020 117";

        System.out.println(MyDate.getDateEndQuery(s));

    }
}