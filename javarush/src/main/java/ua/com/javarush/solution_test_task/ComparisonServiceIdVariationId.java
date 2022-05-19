package ua.com.javarush.solution_test_task;

public class ComparisonServiceIdVariationId {

     static boolean isServiceIdEquals(int serviceIdQuery, int serviceIdWaitTime) {
        return serviceIdQuery == serviceIdWaitTime;
    }

     static boolean isVariationIdEquals(int variationIdQuery, int variationIdWaitTime) {
        return variationIdQuery == variationIdWaitTime;
    }
}
