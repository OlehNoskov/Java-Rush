package ua.com.javarush.garbage.first_task_solution;

import java.text.ParseException;

public class Solution {
//    private static final String fileNameInputData = "input.txt";
    private static final String fileNameInputData = "C:\\Users\\Олег и Ирина\\IdeaProjects\\Java Rush\\javarush\\src\\main\\java\\ua\\com\\javarush\\solution_test_task\\input.txt";

    public static void main(String[] args) throws ParseException {
        SearchQuery searchQuery = new SearchQuery();
        searchQuery.addValidRequestsAndWaitTimeline(fileNameInputData);
    }
}