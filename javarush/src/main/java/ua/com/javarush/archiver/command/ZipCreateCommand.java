package ua.com.javarush.archiver.command;

import ua.com.javarush.archiver.ConsoleHelper;
import ua.com.javarush.archiver.ZipFileManager;
import ua.com.javarush.archiver.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Создание архива:");
            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите полное имя файла или директории для архивации:");
            Path pathArchiver = Paths.get(ConsoleHelper.readString());
            zipFileManager.createZip(pathArchiver);

            ConsoleHelper.writeMessage("Архив создан!");
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}