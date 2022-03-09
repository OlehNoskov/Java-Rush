package ua.com.javarush.multithreading.comparator;


import java.util.Arrays;
import java.util.Comparator;

public class SearchMidAndSortingComparator {

    public static void main(String[] args) {
        Integer[] integers = {13, 8, 15, 5, 17, 20, 22, 30, 50, 7, 11, 19};
        sort(integers);
        for (Integer integer : integers) {
            System.out.print(integer + ",");
        }
    }

    public static Integer[] sort(Integer[] array) {
        final double mediana = getMediana(array);

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double v1 = o1.intValue() - mediana;
                double v2 = o2.intValue() - mediana;
                return (int) ((v1 * v1 - v2 * v2) * 100);
            }
        });

        return array;
    }

    private static double getMediana(Integer[] array) {
        Arrays.sort(array);
        double res;
        int length = array.length;

        if (length % 2 == 1) {
            res = array[length / 2];
        } else {
            res = (array[length / 2 - 1] + array[length / 2]) / 2.;
        }
        return res;
    }
}