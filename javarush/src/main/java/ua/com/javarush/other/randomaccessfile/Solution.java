package ua.com.javarush.other.randomaccessfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

// write in file with RandomAccessFile
public class Solution {
    private static String filename;
    private static String text;
    private static int number;

    public static void main(String[] args) {
        filename = args[0];
        number = Integer.parseInt(args[1]);
        text = args[2];

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(filename, "rw");
            if (number < randomAccessFile.length()) {
                randomAccessFile.seek(number);

            } else {
                randomAccessFile.seek(randomAccessFile.length());
            }
            randomAccessFile.writeBytes(text);
            randomAccessFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found :(");
        } catch (IOException e) {
            System.out.println("This position not found");
        }
    }
}