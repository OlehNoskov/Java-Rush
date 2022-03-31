package ua.com.javarush.html_editor;

import javax.swing.filechooser.FileFilter;

import java.io.File;

public class HTMLFileFilter extends FileFilter {

    //Сравнение расширения файла
    @Override
    public boolean accept(File f) {
        return ((f.isDirectory())
                || (f.getName().toLowerCase().endsWith(".htm"))
                || (f.getName().toLowerCase().endsWith(".html")));
    }

    @Override
    public String getDescription() {
        return "HTML и HTML файлы";
    }
}