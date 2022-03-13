package ua.com.javarush.chat_project.client;

import ua.com.javarush.chat_project.Connection;
import ua.com.javarush.chat_project.ConsoleHelper;
import ua.com.javarush.chat_project.Message;
import ua.com.javarush.chat_project.MessageType;

import java.io.IOException;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected;

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя:");
        return ConsoleHelper.readString();
    }

    public class SocketThread extends Thread {
    }

        protected SocketThread getSocketThread() {
            return new SocketThread();
        }

        protected void sendTextMessage(String text) {
            try {
                connection.send(new Message(MessageType.TEXT, text));
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не удалось отправить сообщение!");
                clientConnected = false;
            }
        }

        protected boolean shouldSendTextFromConsole() {
            return true;
        }

        public void run() {
            SocketThread socketThread = getSocketThread();
            // Помечаем поток как daemon
            socketThread.setDaemon(true);
            socketThread.start();

            try {
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
                return;
            }

            if (clientConnected)
                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
            else
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

            // Пока не будет введена команда exit, считываем сообщения с консоли и отправляем их на сервер
            while (clientConnected) {
                String text = ConsoleHelper.readString();
                if (text.equalsIgnoreCase("exit"))
                    break;

                if (shouldSendTextFromConsole())
                    sendTextMessage(text);
            }
        }

    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        client.run();
    }
}