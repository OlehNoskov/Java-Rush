package ua.com.javarush.collections;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    private static final String nameFirstFile = "file1.txt";
    private static final String nameSecondFile = "file2.txt";
    private static int ZERO = 0;
    private static final int COUNT = 5;

    public static void main(String[] args) {
        getResult(nameFirstFile);
        System.out.println();
        getResult(nameSecondFile);
    }

    private static void getResult(String nameFile) {
        Set<Character> characters = new TreeSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nameFile))) {
            while (reader.ready()) {
                String line = reader.readLine().toLowerCase();
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isLetter(line.charAt(i))) {
                        characters.add(line.charAt(i));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File not found!");
        }
        for (Character character : characters) {
            System.out.print(character);
            ZERO++;
            if (ZERO == COUNT)
                break;
        }
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
//
//        TreeSet<Character> characters = new TreeSet<>();
//
//        String s;
//        while ((s = reader.readLine()) != null) {
//            for (char ch : s.toLowerCase().toCharArray()) {
//                if (ch >= 97 && ch <= 122)
//                    characters.add(ch);
//            }
//        }
//
//        reader.close();
//
//        int count = 0;
//        for (Character c : characters) {
//            System.out.print(c);
//            count++;
//            if (count == 5) {
//                break;
//            }
//        }
//    }
}