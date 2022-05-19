package ua.com.javarush.solution_test_task;

public class WaitTimelineValid {

    static boolean isValidWaitTimeline(String query) {
        return isValidServiceIdAndVariationId(query) &&
                ValidQuestionTypeCategorySubCategory.isValidQuestionTypeCategorySubCategory(query);
    }

    private static boolean isValidServiceIdAndVariationId(String query) {
        boolean valid = false;
        String serviceIdVariationId = QueryStringData.getLineArray(query)[1] + QueryStringData.getLineArray(query)[2];
        String regexValidServiceAndVariation = "\\d\\d?\\.? \\d\\d?\\.? \\d?\\d?\\.? \\d?\\d?";

        if (serviceIdVariationId.matches(regexValidServiceAndVariation)) {
            if (CompanyServices.isValidNumberService(QueryStringData.getNumberServiceId(serviceIdVariationId))
                    && CompanyServices.isValidNumberVariation(QueryStringData.getNumberVariationId(serviceIdVariationId))) {
                valid = true;
            }
        }
        return valid;
    }
}