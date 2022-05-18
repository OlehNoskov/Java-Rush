package ua.com.javarush.solution_test_task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchQuery {
    //    private static final String fileNameInputData = "input.txt";
    private static final String fileNameInputData = "C:\\Users\\Олег и Ирина\\IdeaProjects\\Java Rush\\javarush\\src\\main\\java\\ua\\com\\javarush\\solution_test_task\\input.txt";
    private static final List<String> listValidRequest = new ArrayList<>();
    private static final List<String> listValidWaitTimeline = new ArrayList<>();

    public void addValidRequestsAndWaitTimeline() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileNameInputData))) {
            String line = reader.readLine();
            while (line != null) {
                if (ValidQuery.isQuery(line)) {
                    listValidRequest.add(line);
                }
                if (WaitTimelineValid.isValidWaitTimeline(line)) {
                    listValidWaitTimeline.add(line);
                }
                line = reader.readLine();
            }
            for (String s : listValidRequest) {
                System.out.println(s);
            }
            System.out.println();

            for(String s: listValidWaitTimeline){
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, file not found!");
        } catch (IOException e) {
            System.out.println("Sorry, some error has occurred!");
        }
    }
}