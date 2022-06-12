package ua.com.javarush.other.stringreader_stringwriter;

import java.io.*;

// read from input
public class ReadFromInput {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("D:\\Документы Олега\\Test.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if (is != null) {
            char[] buffer = new char[1024];
            try (Reader reader = new BufferedReader(new InputStreamReader(is))) {
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            }
        }
        return writer;
    }
}