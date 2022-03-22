package ua.com.javarush.archiver.command;

import ua.com.javarush.archiver.ConsoleHelper;
import ua.com.javarush.archiver.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
            ConsoleHelper.writeMessage("Удаление архива:");
            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите название файла для удаления:");
            Path destinationPath = Paths.get(ConsoleHelper.readString());
            zipFileManager.removeFile(destinationPath);

            ConsoleHelper.writeMessage("Архив удалён!");
    }
}