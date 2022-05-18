package ua.com.javarush.solution_test_task;

public class ValidNumberServiceAndVariation {
    static boolean isValidServiceIdAndVariationId(String[] query) {
        boolean valid = false;
        String serviceIdVariationId = query[1];
        String allService = query[1] + query[2];
        String regexValidServiceAndVariation = "\\d\\d?\\.\\d";
        String regexSearchAllService = "\\d{1,2}\\*";

        if (serviceIdVariationId.matches(regexValidServiceAndVariation)) {
            if (CompanyServices.isValidNumberService(getValidNumberServiceId(serviceIdVariationId))
                    && CompanyServices.isValidNumberVariation(getValidNumberVariationId(serviceIdVariationId))) {
                valid = true;
            }
        }
        if (allService.matches(regexSearchAllService)) {
            if (CompanyServices.isValidNumberService(Integer.parseInt(query[1]))) {
                valid = true;
            }
        }
        return valid;
    }

    private static int getValidNumberServiceId(String query) {
        return Integer.parseInt(query.split("\\.")[0]);
    }

    private static int getValidNumberVariationId(String query) {
        return Integer.parseInt(query.split("\\.")[1]);
    }
}