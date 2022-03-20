package ua.com.javarush.archiver.command;

import ua.com.javarush.archiver.ConsoleHelper;
import ua.com.javarush.archiver.FileProperties;
import ua.com.javarush.archiver.ZipFileManager;

public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого фалйа:");
        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Содержимое архива:");
        for (FileProperties fileProperties : zipFileManager.getFilesList()) {
            ConsoleHelper.writeMessage(fileProperties.toString());
        }
        ConsoleHelper.writeMessage("Содержимое архива прочитано!");
    }
}