package ua.com.javarush.solution_test_task;

import java.util.List;

public class WaitTime {

    static String getSymbolWaitTime(){
        return "C";
    }

    static boolean isWaitTimeline(String query) {
        boolean validTypeWaitTimeline = false;

        if (QueryStringData.getTypeQuery(query).equals(getSymbolWaitTime())) {
            validTypeWaitTimeline = true;
        }
        return validTypeWaitTimeline;
    }

    static int getResultWaitingTime(List<Integer> waitingTime) {
        int result = 0;
        for (Integer time : waitingTime) {
            result += time;
        }
        return result / waitingTime.size();
    }

    static int getWaitingTime(String query) {
        return Integer.parseInt(QueryStringData.getLineArray(query)[getLastIndexArray(query)]);
    }

    private static int getLastIndexArray(String query) {
        return QueryStringData.getLineArray(query).length - 1;
    }
}