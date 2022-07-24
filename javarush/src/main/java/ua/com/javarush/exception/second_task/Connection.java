package ua.com.javarush.exception.second_task;

public interface Connection {
    void connect() throws WrongDataException, ConnectionException;

    void write(Object data) throws WrongDataException, ConnectionException;

    Object read() throws WrongDataException, ConnectionException;

    void disconnect() throws WrongDataException, ConnectionException;
}