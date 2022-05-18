package ua.com.javarush.solution_test_task;

public class Solution {

    public static void main(String[] args) {
        SearchQuery searchQuery = new SearchQuery();
        searchQuery.getString();
        String array = "D 10 * P 01.01.2012-01.12.2012";
//        String array = "D 10.1 8 P 01.01.2012-01.12.2012";

        System.out.println( ValidNumberServiceAndVariation.isValidServiceIdAndVariationId(ValidQuery.lineArray(array)));
    }
}