package ua.com.javarush.archiver;

import java.io.IOException;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;

public class FileManager {
    private Path rootPath;
    private List<Path> fileList;

    public FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        collectFilesList(rootPath);
    }

    public List<Path> getFileList() {
        return fileList;
    }

    private void collectFilesList(Path path) throws IOException {
        //Проверка, что path является файлом!
        if (Files.isRegularFile(path)) {
            //Получение относительного пути файла относительно к rootPath и добавленние в список.
            fileList.add(rootPath.relativize(path));
            //Если путь это директория
        } else if (Files.isDirectory(path)) {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            //Проходит мо содержимому директории
            for (Path entry: directoryStream){
                collectFilesList(entry);
            }
            directoryStream.close();
        }
    }
}