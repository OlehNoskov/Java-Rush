package ua.com.javarush.exception.second_task;

public class WrongDataException extends Exception {
    public WrongDataException() {
        super();
    }

    public WrongDataException(String message) {
        super(message);
    }
}