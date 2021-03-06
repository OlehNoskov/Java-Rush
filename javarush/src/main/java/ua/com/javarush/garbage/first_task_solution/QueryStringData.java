package ua.com.javarush.garbage.first_task_solution;

public class QueryStringData {

    public static String[] getLineArray(String query) {
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

    static String getTypeAnswer(String query) {
        return getLineArray(query)[3];
    }

    static String getDateString(String query) {
        return getLineArray(query)[4];
    }

    static int getWaitTime(String query){
        return Integer.parseInt(getLineArray(query)[5]);
    }

    static String getAllSearch(){
        return "*";
    }

    public static int getNumberServiceId(String query) {
        return Integer.parseInt(getIdServiceAndVariationId(query).split("\\.")[0]);
    }

    public static int getNumberVariationId(String query) {
        int result = 0;
        if (getIdServiceAndVariationId(query).split("\\.").length > 1) {
            result = Integer.parseInt(getIdServiceAndVariationId(query).split("\\.")[1]);
        }
        return result;
    }

    public static int getNumberQuestionType(String numbers) {
        int result = 0;
        if(!numbers.equals(getAllSearch())){
            result = Integer.parseInt(getQuestionTypeCategorySubCategory(numbers).split("\\.")[0]);
        }
        System.out.println(numbers);
        return result;
    }

    public static int getNumberCategory(String numbers) {
        int result = 0;
        if (getQuestionTypeCategorySubCategory(numbers).split("\\.").length > 1) {
            result = Integer.parseInt(getQuestionTypeCategorySubCategory(numbers).split("\\.")[1]);
        }
        return result;
    }

    public static int getNumberSubCategory(String numbers) {
        int result = 0;
        if (getQuestionTypeCategorySubCategory(numbers).split("\\.").length > 2) {
            result = Integer.parseInt(getQuestionTypeCategorySubCategory(numbers).split("\\.")[2]);
        }
        return result;
    }
}