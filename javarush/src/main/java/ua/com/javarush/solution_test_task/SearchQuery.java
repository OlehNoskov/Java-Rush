package ua.com.javarush.solution_test_task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.text.ParseException;
import java.util.*;

public class SearchQuery {

    private static final List<String> listValidRequest = new ArrayList<>();
    private static final List<String> listValidWaitTimeline = new ArrayList<>();
    private static final List<Integer> listWaitTime = new ArrayList<>();

    public void addValidRequestsAndWaitTimeline(String pathFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))) {
            String line = reader.readLine();

            while (line != null) {
                if (Query.isQuery(line)) {
                    if (Query.isQuery(line)) {
                        listValidRequest.add(line);
                    }
                }
                if (WaitTime.isWaitTimeline(line)) {
                    listValidWaitTimeline.add(line);
                }
                line = reader.readLine();
            }
            printOutputResult();

            for (String s : listValidRequest) {
                System.out.println(s);
            }
            System.out.println();
            for (String s : listValidWaitTimeline) {
                System.out.println(s);
            }
            System.out.println();

            for (Integer integer : listWaitTime) {
                System.out.println(integer);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, file not found!");
        } catch (IOException | ParseException e) {
            System.out.println("Sorry, some error has occurred!");
        }
    }

    public void printOutputResult() throws ParseException {
        List<Integer> minutes = new ArrayList<>();
        int index = 0;

        for (String s : listValidRequest) {
            for (String s2 : listValidWaitTimeline) {
                index++;
                if (ComparisonServiceIdVariationId.isServiceIdEquals
                        (QueryStringData.getNumberServiceId(s), QueryStringData.getNumberServiceId(s2))) {
                    minutes.add(WaitTime.getWaitingTime(s2));
                } else {
                    if (index == listValidWaitTimeline.size()) {
                        listWaitTime.add(WaitTime.getResultWaitingTime(minutes));
                        minutes.clear();
                        index = 0;
                    }
                }
            }
        }
    }
}