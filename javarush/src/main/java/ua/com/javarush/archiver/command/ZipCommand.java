package ua.com.javarush.archiver.command;

import ua.com.javarush.archiver.ConsoleHelper;
import ua.com.javarush.archiver.ZipFileManager;

import java.nio.file.Paths;

public abstract class ZipCommand implements Command {
    public ZipFileManager getZipFileManager() throws Exception {
        ConsoleHelper.writeMessage("Введите полный путь файла архива:");
        String pathFile = ConsoleHelper.readString();
        return new ZipFileManager(Paths.get(pathFile));
    }
}