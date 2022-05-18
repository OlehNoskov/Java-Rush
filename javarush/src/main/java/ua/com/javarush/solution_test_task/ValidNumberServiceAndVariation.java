package ua.com.javarush.solution_test_task;

/*
 Validation of the correct incoming data of the service number and service variant
 */
public class ValidNumberServiceAndVariation {

    static boolean isValidServiceIdAndVariationId(String[] query) {
        boolean valid = false;
        String serviceIdVariationId = query[1];
        String regexValidServiceAndVariation = "\\d\\d?\\.\\d";

        if (serviceIdVariationId.matches(regexValidServiceAndVariation)) {
            if (CompanyServices.isValidNumberService(getNumberServiceId(serviceIdVariationId))
                    && CompanyServices.isValidNumberVariation(getValidVariationId(serviceIdVariationId))) {
                valid = true;
            }
        }
        return valid;
    }

    static boolean isValidOnlyService(String[] query) {
        boolean valid = false;
        String allService = query[1] + query[2];
        String regexSearchAllService = "\\d{1,2}\\*";
        if (allService.matches(regexSearchAllService)) {
            if (CompanyServices.isValidNumberService(Integer.parseInt(query[1]))) {
                valid = true;
            }
        }
        return valid;
    }

    private static int getNumberServiceId(String query) {
        return Integer.parseInt(query.split("\\.")[0]);
    }

    private static int getValidVariationId(String query) {
        return Integer.parseInt(query.split("\\.")[1]);
    }
}