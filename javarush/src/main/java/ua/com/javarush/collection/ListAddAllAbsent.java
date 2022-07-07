package ua.com.javarush.collection;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// Поиск класса по описанию
public class ListAddAllAbsent {
    public static void main(String... args) {    //it's correct line
        // Потоко безопастный Array List
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.remove("B");
        List<String> collection = Arrays.asList("B", "C", "D", "B");

        // Добавляет в список все отсутствующие в 1 списке элементы со 2 списка
        list.addAllAbsent(collection);

        for (String string : list) {
            System.out.println(string);
        }
        /* Expected output
A
C
B
D
         */
    }
}