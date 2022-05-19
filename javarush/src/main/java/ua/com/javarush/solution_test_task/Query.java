package ua.com.javarush.solution_test_task;

public class Query {

    static String getSymbolQuery() {
        return "D";
    }

    static boolean isQuery(String query) {
        boolean validTypeQuery = false;

        if (QueryStringData.getTypeQuery(query).equals(getSymbolQuery())) {
            validTypeQuery = true;
        }
        return validTypeQuery;
    }
}