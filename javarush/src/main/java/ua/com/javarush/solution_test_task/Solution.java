package ua.com.javarush.solution_test_task;

public class Solution {

    public static void main(String[] args) {
        SearchQuery searchQuery = new SearchQuery();
        searchQuery.getString();
//        String array = "D 1.1 8.15.1 P 15.10.2012 83 ";
        String array = "D 1.1 10.1.2 P 15.10.2012 83";
        int time = WaitTimeline.getWaitingTime(array);
        System.out.println("_______________");
        System.out.println(time);

    }
}