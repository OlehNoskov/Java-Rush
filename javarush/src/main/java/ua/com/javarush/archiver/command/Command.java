package ua.com.javarush.archiver.command;

import java.io.IOException;

public interface Command {

    void execute() throws IOException;
}
