package ua.com.javarush.tasks_for_work_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SmartSearchFilesInDirectory {
    public static void main(String[] args) throws IOException {
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();

        searchFileVisitor.setPartOfName("65");
        searchFileVisitor.setPartOfContent("programmer");
        searchFileVisitor.setMinSize(500);
        searchFileVisitor.setMaxSize(10000);

        Files.walkFileTree(Paths.get("D:/Документы Олега"), searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();
        for (Path file : foundFiles) {
            System.out.println(file);
        }
    }
}