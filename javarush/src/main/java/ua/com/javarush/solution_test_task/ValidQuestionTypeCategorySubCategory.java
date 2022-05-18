package ua.com.javarush.solution_test_task;

public class ValidQuestionTypeCategorySubCategory {

    static boolean isValidQuestionType(String[] query) {
        boolean valid = false;
        String[] arrayNumbers = getSecondArrayCell(query).split("\\.");

        if (arrayNumbers.length == 1 && CompanyServices.isValidNumberQuestionType(getNumberQuestionType(arrayNumbers[0]))) {
            valid = true;
        }
        return valid;
    }

    static boolean isValidQuestionTypeCategorySubCategory(String[] query) {
        boolean valid = false;
        String regexValidQuestionTypeCategorySubCategory = "\\d\\d?\\.\\d\\d?\\d";
        String[] arrayNumbers = getSecondArrayCell(query).split("\\.");

        if (isValidIValidInputData(getSecondArrayCell(query))) {
            valid = true;
        }
        return valid;
    }

    private static String getSecondArrayCell(String[] number){
        return number[2];
    }

    private static int getNumberQuestionType(String number) {
        return Integer.parseInt(number.split("\\.")[0]);
    }

    private static int getNumberCategory(String number) {
        return Integer.parseInt(number.split("\\.")[1]);
    }

    private static int getNumberSubCategory(String query) {
        return Integer.parseInt(query.split("\\.")[2]);
    }

    private static boolean isValidIValidInputData(String numbers){
        return CompanyServices.isValidNumberQuestionType(getNumberQuestionType(numbers))
                && CompanyServices.isValidNumberCategory(getNumberCategory(numbers))
                && CompanyServices.isValidNumberSubCategory(getNumberSubCategory(numbers));
    }
}