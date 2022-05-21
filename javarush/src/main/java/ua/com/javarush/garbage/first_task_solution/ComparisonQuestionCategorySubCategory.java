package ua.com.javarush.garbage.first_task_solution;

public class ComparisonQuestionCategorySubCategory {

    static boolean isQuestionType(int questionIdQuery,int questionIdWaitTime) {
        return questionIdQuery == questionIdWaitTime;
    }

    static boolean isCategoryEquals(int categoryIdQuery, int categoryIdWaitTime) {
        return categoryIdQuery == categoryIdWaitTime;
    }

    static boolean isSubCategoryIdEquals(int subCategoryIdQuery, int subCategoryIdWaitTime) {
        return subCategoryIdQuery == subCategoryIdWaitTime;
    }
}