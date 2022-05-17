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
    private static List<String> listValidRequest = new ArrayList<>();

    public void getString() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileNameInputData))) {
            String line = reader.readLine();
            while (line != null) {
                if (isQuery(line)) {
                    listValidRequest.add(line);
                }
                line = reader.readLine();
            }
            for (String s : listValidRequest) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, file not found!");
        } catch (IOException e) {
            System.out.println("Sorry, some error has occurred!");
        }
    }

    private static boolean isQuery(String query) {
        boolean validTypeQuery = false;
        String typeQuery = "D";
        String[] wordsOfLine = query.split(" ");
        if (wordsOfLine[0].equals(typeQuery)) {
            validTypeQuery = true;
        }
        return validTypeQuery;
    }

    private static boolean isValidQuery(String query) {
        boolean validQuery = false;
        String regex = "^.{1}\s\\d\\.\\d\s\\d\\.\\d\\d\\.\\d\s.\s\\d{2}\\.\\d{2}\\d{4}\s\\d\\d$";
        return validQuery;
    }
}