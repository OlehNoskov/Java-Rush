package ua.com.javarush.solution_test_task;

/*
 Validation of the correct incoming data of the service number and service variant
 */

public class ValidNumberServiceAndVariation {

    static boolean isValidServiceIdAndVariationId(String query) {
        boolean valid = false;
        String serviceIdVariationId = Query.lineArray(query)[1];
        String regexValidServiceAndVariation = "\\d\\d?\\.\\d\\d?";

        if (serviceIdVariationId.matches(regexValidServiceAndVariation)) {
            if (CompanyServices.isValidNumberService(getNumberServiceId(serviceIdVariationId))
                    && CompanyServices.isValidNumberVariation(getNumberVariationId(serviceIdVariationId))) {
                valid = true;
            }
        }
        return valid;
    }

    private static boolean isValidOnlyService(String query) {
        boolean valid = false;
        String allService = Query.lineArray(query)[1] + Query.lineArray(query)[2];
        String onlyService = Query.lineArray(query)[1];

        String regexSearchAllService = "\\d{1,2}\\*?";
        if (allService.matches(regexSearchAllService) || onlyService.matches(regexSearchAllService)) {
            if (CompanyServices.isValidNumberService(Integer.parseInt(Query.lineArray(query)[1]))) {
                valid = true;
            }
        }
        return valid;
    }

    static boolean isQueryValid(String query) {
        return isValidServiceIdAndVariationId(query) || isValidOnlyService(query);
    }

    static int getNumberServiceId(String query) {
        return Integer.parseInt(query.split("\\.")[0]);
    }

    static int getNumberVariationId(String query) {
        int result = 0;
        if (query.split("\\.").length > 1) {
            result = Integer.parseInt(query.split("\\.")[1]);
        }
        return result;
    }
}