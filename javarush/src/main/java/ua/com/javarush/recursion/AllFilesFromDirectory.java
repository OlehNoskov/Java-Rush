package ua.com.javarush.recursion;

import java.io.File;

public class AllFilesFromDirectory {
    public static void main(String[] args) {
        printFiles(new File("D:\\Документы Олега"));
    }


    //Нахождение всех файлов с помощью рекурсивного вызова метода
    public static void printFiles(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                printFiles(dir);  //Вызов рекурсивного метода
            } else {
                System.out.println(file.getAbsoluteFile());
            }
        }
    }
}