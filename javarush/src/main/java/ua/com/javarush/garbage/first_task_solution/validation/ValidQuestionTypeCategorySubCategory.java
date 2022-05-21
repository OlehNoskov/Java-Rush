package ua.com.javarush.garbage.first_task_solution.validation;

import ua.com.javarush.garbage.first_task_solution.QueryStringData;

/*
Validation of the correct incoming data of the QuestionType, Categories and SubCategories
 */
public class ValidQuestionTypeCategorySubCategory {

    static boolean isValidQuestionType(String query) {
        boolean valid = false;
        String[] arrayNumbers = (QueryStringData.getLineArray(query))[2].split("\\.");

        if (arrayNumbers.length == 1 &&
                CompanyServices.isValidNumberQuestionType(QueryStringData.getNumberQuestionType(arrayNumbers[0]))) {
            valid = true;
        }
        return valid;
    }

    public static boolean isValidQuestionTypeCategorySubCategory(String query) {
        boolean valid = false;
        if (isCorrectInputData(QueryStringData.getLineArray(query))
                && isValidInputData(QueryStringData.getLineArray(query)[2])) {
            valid = true;
        }
        return valid;
    }

    private static boolean isValidInputData(String numbers) {
        return CompanyServices.isValidNumberQuestionType(QueryStringData.getNumberQuestionType(numbers))
                && CompanyServices.isValidNumberCategory(QueryStringData.getNumberCategory(numbers))
                && CompanyServices.isValidNumberSubCategory(QueryStringData.getNumberSubCategory(numbers));
    }

    private static boolean isCorrectInputData(String[] query) {
        String regexValidQuestionTypeCategorySubCategory = "\\d\\d?(\\.\\d\\d?)?(\\.\\d\\d?)?";
        return (query)[2].matches(regexValidQuestionTypeCategorySubCategory);
    }
}