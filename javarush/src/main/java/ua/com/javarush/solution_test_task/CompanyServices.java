package ua.com.javarush.solution_test_task;

/*
 * Number of types of services provided by the company
 * */
public class CompanyServices {

    private static int getAmountService() {
        return 10;
    }

    private static int getAmountVariationService() {
        return 3;
    }

    private static int getAmountQuestionType() {
        return 10;
    }

    private static int getAmountCategory() {
        return 20;
    }

    private static int getAmountSubCategory() {
        return 5;
    }

    static boolean isValidNumberService(int numberService) {
        return numberService >= 1 && numberService <= getAmountService();
    }

    static boolean isValidNumberVariation(int numberVariation) {
        return numberVariation >= 1 && numberVariation <= getAmountVariationService();
    }

    static boolean isValidNumberQuestionType(int questionType) {
        return questionType >= 1 && questionType <= getAmountQuestionType();
    }

    static boolean isValidNumberCategory(int numberCategory) {
        return numberCategory >= 1 && numberCategory <= getAmountCategory();
    }

    static boolean isValidNumberSubCategory(int numberSubCategory) {
        return numberSubCategory >= 1 && numberSubCategory <= getAmountSubCategory();
    }

    static String getTypeFirstAnswer() {
        return "P";
    }

    static String getTypeNextAnswer() {
        return "N";
    }
}