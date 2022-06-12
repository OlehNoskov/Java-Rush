package ua.com.javarush.other.stringreader_stringwriter;

import java.io.IOException;
import java.io.StringReader;

//Расшифрока строки
public class CaesarsCipher {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringBuilder builder = new StringBuilder();
        int numberChar;
        if (reader != null) {
            while ((numberChar = reader.read()) != -1) {
                char ch = (char) numberChar;
                builder.append((char) (ch + key));
            }
        }
        return builder.toString();
    }
}