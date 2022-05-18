package ua.com.javarush.solution_test_task;

import java.util.List;

public class WaitTimeline {

    static int getResultWaitingTime(List<Integer> waitingTime) {
        int result = 0;
        for (Integer time : waitingTime) {
            result += time;
        }
        return result / waitingTime.size();
    }

    static int getWaitingTime(String query) {
        return Integer.parseInt(ValidQuery.lineArray(query)[getLastIndexArray(query)]);
    }

    private static int getLastIndexArray(String query) {
        return ValidQuery.lineArray(query).length - 1;
    }
}