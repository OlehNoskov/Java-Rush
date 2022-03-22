package ua.com.javarush.archiver.command;

import ua.com.javarush.archiver.ConsoleHelper;
import ua.com.javarush.archiver.ZipFileManager;
import ua.com.javarush.archiver.exception.WrongZipFileException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand{
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Распаковка архива:");
            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите путь для распаковки:");
            Path destinationPath = Paths.get(ConsoleHelper.readString());
            zipFileManager.extractAll(destinationPath);

            ConsoleHelper.writeMessage("Архив распакован!");
        } catch (WrongZipFileException e) {
            ConsoleHelper.writeMessage("Архиа не существует.");
        }
    }
}
