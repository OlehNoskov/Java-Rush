package ua.com.javarush.solution_test_task;

public class Query {

    static boolean isQuery(String query) {
        boolean validTypeQuery = false;
        String typeQuery = "D";
        if (QueryStringData.getTypeQuery(query).equals(typeQuery)) {
            validTypeQuery = true;

        }
        return validTypeQuery;
    }
}