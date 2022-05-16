package ua.com.javarush.tasks_for_work_files;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class WhatIsInsideFile {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please, enter folder path:");
            File file = new File(reader.readLine());
            int overallSizeDirectory = 0;
            int countDirectories = 0;
            if (!file.isDirectory()) {
                System.out.println("Sorry, you entered incorrect folder path!");
            } else {
                System.out.println("Information about this directory:");
                for (String path : getFileTree(file.getAbsolutePath())) {
                    File file1 = new File(path);
                    BasicFileAttributes basicFileAttributes = Files.readAttributes(file1.toPath(), BasicFileAttributes.class);
                    if (basicFileAttributes.isDirectory()) {
                        countDirectories++;
                    } else {
                        overallSizeDirectory += basicFileAttributes.size();
                    }
                }
                System.out.println("Amount all directories:" + countDirectories);
                System.out.println("Amount all files:" + getFileTree(file.getAbsolutePath()).size());
                System.out.println("Overall size this directory:" + overallSizeDirectory);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Пример нахождения всех файлов в директории и поддиректориях!!!
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(Paths.get(root), options, 20, new SearchAllFiles.GetFiles(result));

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
}