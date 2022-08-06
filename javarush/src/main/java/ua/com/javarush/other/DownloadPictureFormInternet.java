package ua.com.javarush.other;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

public class DownloadPictureFormInternet {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://klike.net/uploads/posts/2019-11/1574605232_1.jpg");
        // устанавливаем соединение
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

        // Получаем стрим, чтобы писать в него данные запроса
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(1);
        outputStream.flush();

        // Получаем стрим, чтобы читать из него данные
        InputStream inputStream = url.openStream();
        Files.copy(inputStream, new File("D:\\Картинки\\image.jpg").toPath());
     }
}