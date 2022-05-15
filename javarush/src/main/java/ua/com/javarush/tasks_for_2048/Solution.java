package ua.com.javarush.tasks_for_2048;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Solution {
    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/Загрузки!!!"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }
//Пример скачивания файла из интернета
    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        String fileName = urlString.split("/")[urlString.split("/").length - 1];
        Path downloadPath = downloadDirectory.resolve(fileName);

        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();

        Path tempFile = Files.createTempFile(null, null);
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

        Files.move(tempFile, downloadPath);
        return downloadPath;
    }
}