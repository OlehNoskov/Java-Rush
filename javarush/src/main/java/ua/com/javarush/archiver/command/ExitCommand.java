package ua.com.javarush.archiver.command;

import ua.com.javarush.archiver.ConsoleHelper;

import java.io.IOException;

public class ExitCommand implements Command {

    @Override
    public void execute() throws IOException {
        ConsoleHelper.writeMessage("До встречи!");
    }
}