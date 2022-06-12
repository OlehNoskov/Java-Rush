package ua.com.javarush.other.stringreader_stringwriter;

import java.io.PrintWriter;
import java.io.StringWriter;

public class WriteStackTrace {
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);

        return null;
    }
}