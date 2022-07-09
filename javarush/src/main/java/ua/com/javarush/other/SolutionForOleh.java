package ua.com.javarush.other;

import java.util.Arrays;

public class SolutionForOleh {
    static int[] first = {1, 2, 5};
    static int[] second = {3, 6, 1};

    static String stringFirst = "abc";
    static String stringSecond = "abcdef";

    public static void main(String[] args) {
        System.out.println(Arrays.toString(splitString(stringFirst)));
        System.out.println(Arrays.toString(splitString(stringSecond)));
    }

    static String[] splitString(String string) {
        int lengthArray = string.length();
        int count = 0;

        String[] stringsToArray = string.split("");
        String[] result;

        // Если размер массива четный
        if (lengthArray % 2 == 0) {
            result = new String[lengthArray / 2]; // Размер в 2 раза меньше от исходного массива
            // так как мы соединяем по 2 элемента

            for (int i = 0; i < stringsToArray.length; i += 2) {
                String current = stringsToArray[i] + stringsToArray[i + 1];
                result[count] = current;

                //счетчик номера ячейки для итогового массива
                count++;
            }
        } else {
            result = new String[lengthArray / 2 + 1]; // Размер в 2 + 1 раза меньше от исходного массива
            // так как мы соединяем по 2 элемента, и деление нечетного
            // приведет к тому, что будет не хватать одной ячейки в массиве, поэтому +1

            for (int i = 0; i < stringsToArray.length - 1; i += 2) {
                String current = stringsToArray[i] + stringsToArray[i + 1];
                result[count] = current;

                //счетчик номера ячейки для итогового массива
                count++;
            }
            // Ложу последний элемент в последнюю ячейку и добавляю символ "_"
            result[result.length - 1] = stringsToArray[stringsToArray.length - 1] + "_";
        }
        return result;
    }

    // Метод, который возвращает массив с суммой значений элементов двух массивов
    static int[] combineArrays(int[] first, int[] second) {
        int[] result = new int[first.length]; // В Java нужно задавать размер массива, поэтому я взял размер массива first
        for (int i = 0; i < first.length; i++) {
            result[i] = first[i] + second[i]; // Помещаю в массив result в ячейку [i] сумму двух элементов first и second
        }
        return result;
    }
}