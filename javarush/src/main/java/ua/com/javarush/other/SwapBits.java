package ua.com.javarush.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Смена битов числа в двоичном представлении
 */

public class SwapBits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please enter the first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second index: ");
        int j = Integer.parseInt(reader.readLine());

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {
        String tempString = String.valueOf(new StringBuilder().append(Long.toBinaryString(number)).reverse());
        char[] chars = tempString.toCharArray();
//        char[] chars = Long.toBinaryString(number).toCharArray();
        System.out.println(chars);
        try {
            char first = chars[i];
            char second = chars[j];

            chars[j] = first;
            chars[i] = second;
            System.out.println(chars);
            return Long.parseLong(String.valueOf(chars), 2);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Input index is incorrect!");
        }
        return 0;

//        if (((number >>> i) & 1) != ((number >>> j) & 1)) {
//            long bitMask = (1L << i) | (1L << j);
//            number ^= bitMask;
//        }
//        return number;
    }
}