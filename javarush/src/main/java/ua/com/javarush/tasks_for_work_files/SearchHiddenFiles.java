package ua.com.javarush.tasks_for_work_files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

public class SearchHiddenFiles extends SimpleFileVisitor<Path> {
    public static void main(String[] args) throws IOException {
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        final SearchHiddenFiles solution = new SearchHiddenFiles();
        Files.walkFileTree(Paths.get("D:/Загрузки!!!"), options, 20, solution);

        List<String> result = solution.getArchived();
        System.out.println("All archived files:");
        for (String path : result) {
            System.out.println("\t" + path);
        }

        List<String> failed = solution.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) {
            System.out.println("\t" + path);
        }
    }

    private List<String> archived = new ArrayList<>();
    private List<String> failed = new ArrayList<>();

    public List<String> getArchived() {
        return archived;
    }

    public List<String> getFailed() {
        return failed;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        Objects.requireNonNull(file);
        Objects.requireNonNull(attrs);
        if (file.toString().endsWith(".zip") || file.toString().endsWith(".rar")) {
            archived.add(file.toString());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        failed.add(file.toString());
        return FileVisitResult.SKIP_SUBTREE;
    }
}