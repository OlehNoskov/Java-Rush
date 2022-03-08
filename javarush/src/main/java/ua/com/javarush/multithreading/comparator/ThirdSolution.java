package ua.com.javarush.multithreading.comparator;

import java.util.Arrays;

public class ThirdSolution {

    public static void main(String[] args) {
        Integer[] integers = {2, 1, 4, 3, 5};
        sort(integers);
        for (Integer integer : integers) {
            System.out.print(integer);
        }
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);

        int index;
        if (array.length % 2 == 0) {
            index = (array.length / 2);
        } else
            index = array.length / 2 + 1;

        int mid = array[index - 1];
        System.out.println(mid);

        Integer[] result = new Integer[array.length];
        result[0] = mid;

        return result;
    }
}
