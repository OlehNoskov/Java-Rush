package ua.com.javarush.web.server_socket;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;

public class Connection implements Closeable {
    // сокет, через который сервер общается с клиентом, кроме него - клиент и сервер никак не связаны
    private final Socket socket;
    // поток чтения из сокета
    private final ObjectInputStream in;
    // поток записи в сокет
    private final ObjectOutputStream out;

    public Connection(Socket socket) throws Exception {
        this.socket = socket;
        // Создавать обьект класса ObjectOutputStream (и подобные) нужно до того, как будет
        // создавать обьект класса ObjectInputStream, потому что может возникнуть взаимная блокировка потоков,
        // которые хотят установить соединение через класс Connection!
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    public void send(String message) throws Exception {
        out.writeObject(message);
    }

    public String receive() throws Exception {
        return (String) in.readObject();
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}