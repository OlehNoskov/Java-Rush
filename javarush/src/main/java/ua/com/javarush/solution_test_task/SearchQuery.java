package ua.com.javarush.solution_test_task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SearchQuery {
    //    private static final String fileNameInputData = "input.txt";
    private static final String fileNameInputData = "C:\\Users\\Олег и Ирина\\IdeaProjects\\Java Rush\\javarush\\src\\main\\java\\ua\\com\\javarush\\solution_test_task\\input.txt";
    private static final Map<String, Integer> listValidRequest = new LinkedHashMap();
    private static final Map<String, Integer> listValidWaitTimeline = new LinkedHashMap<>();

    public void addValidRequestsAndWaitTimeline() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileNameInputData))) {
            String line = reader.readLine();
            int index = 1;
            while (line != null) {
                if (ValidQuery.isQuery(line)) {
                    listValidRequest.put(line, index);
                }
                if (WaitTimelineValid.isValidWaitTimeline(line)) {
                    listValidWaitTimeline.put(line, index);
                }
                line = reader.readLine();
                index++;
            }
            listValidRequest.forEach((key, value) -> {;
                System.out.println(key + "=" + value + " ");
            });
            System.out.println();

            listValidWaitTimeline.forEach((key, value) -> {;
                System.out.println(key + "=" + value + " ");
            });
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, file not found!");
        } catch (IOException e) {
            System.out.println("Sorry, some error has occurred!");
        }
    }
}