package ua.com.javarush.collections;

import java.util.Arrays;
import java.util.List;

public class Array {
    public static void main(String[] args) {
        List<Number> numbers = Arrays.asList(1, 2, 3);
        addDataToList(numbers, getData());
        System.out.println(numbers);
    }

    public static Number[] getData() {
        return new Number[]{};
    }

    public static void addDataToList(List<Number> list, Number... data) {
        list.addAll(Arrays.asList(data));
    }
}