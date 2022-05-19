package ua.com.javarush.solution_test_task;

public class QueryStringData {

    static String[] getLineArray(String query) {
        return query.trim().split(" ");
    }

    static String getTypeQuery(String query) {
        return getLineArray(query)[0];
    }

    static String getIdServiceAndVariationId(String query) {
        return getLineArray(query)[1];
    }

    static String getQuestionTypeCategorySubCategory(String query) {
        return getLineArray(query)[2];
    }

    static int getNumberServiceId(String query) {
        return Integer.parseInt(getIdServiceAndVariationId(query).split("\\.")[0]);
    }

    static int getNumberVariationId(String query) {
        int result = 0;
        if (getIdServiceAndVariationId(query).split("\\.").length > 1) {
            result = Integer.parseInt(getIdServiceAndVariationId(query).split("\\.")[1]);
        }
        return result;
    }

    static int getNumberQuestionType(String numbers) {
        return Integer.parseInt(getQuestionTypeCategorySubCategory(numbers).split("\\.")[0]);
    }

    static int getNumberCategory(String numbers) {
        int result = 0;
        if (getQuestionTypeCategorySubCategory(numbers).split("\\.").length > 1) {
            result = Integer.parseInt(getQuestionTypeCategorySubCategory(numbers).split("\\.")[1]);
        }
        return result;
    }

    static int getNumberSubCategory(String numbers) {
        int result = 0;
        if (getQuestionTypeCategorySubCategory(numbers).split("\\.").length > 2) {
            result = Integer.parseInt(getQuestionTypeCategorySubCategory(numbers).split("\\.")[2]);
        }
        return result;
    }
}