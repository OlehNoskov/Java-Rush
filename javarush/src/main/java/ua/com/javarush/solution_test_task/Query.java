package ua.com.javarush.solution_test_task;

public class Query {

    static String[] lineArray(String query) {
        return query.trim().split(" ");
    }

    static boolean isQuery(String query) {
        boolean validTypeQuery = false;
        String typeQuery = "D";
        if (lineArray(query)[0].equals(typeQuery)) {
            if (ValidNumberServiceAndVariation.isQueryValid(query)
                    && ValidQuestionTypeCategorySubCategory.isValidQuestionTypeCategorySubCategory(typeQuery)) {
                validTypeQuery = true;
            }
        }
        return validTypeQuery;
    }
}