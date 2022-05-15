package ua.com.javarush.tasks_for_2048;

import java.io.IOException;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class SearchAllFiles {
    //Пример нахождения всех файлов в директории и поддиректориях!!!

     public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(Paths.get(root), options, 20, new GetFiles(result));

        return result;
    }

    private static class GetFiles extends SimpleFileVisitor<Path> {
        private List<String> result;

        public GetFiles(List<String> result) {
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            String s = path.toAbsolutePath().toString();
            result.add(s);
            return FileVisitResult.CONTINUE;
        }
    }


    public static void main(String[] args) throws IOException {
        for (String file : getFileTree("d:/Документы Олега/IT/Проэкт")) {
            System.out.println(file);
        }
    }
}