package ua.com.javarush.other.randomaccessfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class SecondSolution {
    public static void main(String[] args) {

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw")) {
            long number = Long.parseLong(args[1]);
            String text = args[2];
            long fileLength = randomAccessFile.length();

            randomAccessFile.seek(number);
            byte[] readBytes = new byte[text.length()];
            randomAccessFile.read(readBytes, 0, text.length());

            String readString = new String(readBytes);

            randomAccessFile.seek(fileLength);
            if (readString.equals(text)) {
                randomAccessFile.write("true".getBytes());
            } else {
                randomAccessFile.write("false".getBytes());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("This position not found");
        }
    }
}