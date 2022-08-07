package ua.com.javarush.web.server_socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 4444;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                // accept() будет ждать пока кто-нибудь не захочет подключиться
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
                System.out.println("Server starts!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (Connection connection = new Connection(socket)) {
                while (true) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                    connection.send(bufferedReader.readLine());
                    String message = connection.receive();

                    if (message.equals("exit"))
                        break;

                    System.out.println(message);

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}