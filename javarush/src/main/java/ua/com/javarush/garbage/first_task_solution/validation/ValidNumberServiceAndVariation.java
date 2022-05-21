package ua.com.javarush.garbage.first_task_solution.validation;

/*
 Validation of the correct incoming data of the service number and service variant
 */

import ua.com.javarush.garbage.first_task_solution.QueryStringData;

public class ValidNumberServiceAndVariation {

    static boolean isValidServiceIdAndVariationId(String query) {
        boolean valid = false;
        String serviceIdVariationId = QueryStringData.getLineArray(query)[1];
        String regexValidServiceAndVariation = "\\d\\d?\\.\\d\\d?";

        if (serviceIdVariationId.matches(regexValidServiceAndVariation)) {
            if (CompanyServices.isValidNumberService(QueryStringData.getNumberServiceId(serviceIdVariationId))
                    && CompanyServices.isValidNumberVariation(QueryStringData.getNumberVariationId(serviceIdVariationId))) {
                valid = true;
            }
        }
        return valid;
    }

    private static boolean isValidOnlyService(String query) {
        boolean valid = false;
        String allService = QueryStringData.getLineArray(query)[1] + QueryStringData.getLineArray(query)[2];
        String onlyService = QueryStringData.getLineArray(query)[1];

        String regexSearchAllService = "\\d{1,2}\\*?";
        if (allService.matches(regexSearchAllService) || onlyService.matches(regexSearchAllService)) {
            if (CompanyServices.isValidNumberService(Integer.parseInt(QueryStringData.getLineArray(query)[1]))) {
                valid = true;
            }
        }
        return valid;
    }

    static boolean isQueryValid(String query) {
        return isValidServiceIdAndVariationId(query) || isValidOnlyService(query);
    }
}