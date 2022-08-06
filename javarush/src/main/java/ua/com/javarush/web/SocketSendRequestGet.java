package ua.com.javarush.web;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/**
 * Отправка GET-запроса через сокет
 */

public class SocketSendRequestGet {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
//        try {
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            connection.setRequestMethod("GET");
//
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            String responseLine;
//
//            while ((responseLine = bufferedReader.readLine()) != null) {
//                System.out.println(responseLine);
//            }
//            bufferedReader.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String server = url.getHost();
        String path = url.getPath();

        try (Socket socket = new Socket(server, 80);
             PrintStream out = new PrintStream(socket.getOutputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("GET " + path);
            out.println();

            String line = in.readLine();
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}