package ua.com.javarush.solution_test_task;

import java.util.List;

public class WaitTime {

    static boolean isWaitTimeline(String query) {
        boolean validTypeWaitTimeline = false;
        String typeQuery = "C";
        if (Query.lineArray(query)[0].equals(typeQuery)) {
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
        return Integer.parseInt(Query.lineArray(query)[getLastIndexArray(query)]);
    }

    private static int getLastIndexArray(String query) {
        return Query.lineArray(query).length - 1;
    }
}