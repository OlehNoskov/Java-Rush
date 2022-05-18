package ua.com.javarush.solution_test_task;

public class WaitTimelineValid {

    static boolean isValidWaitTimeline(String query) {
        return ValidNumberServiceAndVariation.isValidServiceIdAndVariationId(query) &&
                ValidQuestionTypeCategorySubCategory.isValidQuestionTypeCategorySubCategory(query);
    }
}