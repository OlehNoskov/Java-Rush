package ua.com.javarush.solution_test_task;

public class WaitTimelineValid {

    static String[] lineArray(String line) {
        return line.trim().split(" ");
    }

    static boolean isValidWaitTimeline(String query) {
        boolean validTypeWaitTimeline = false;
        String typeQuery = "C";
        if (lineArray(query)[0].equals(typeQuery)) {
            validTypeWaitTimeline = true;
        }
        return validTypeWaitTimeline;
    }
}