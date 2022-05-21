package ua.com.javarush.garbage.first_task_solution;

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