package ua.com.javarush.other;

import java.util.Arrays;

public class SolutionOlehsTest {
    public static void main(String[] args) {
        System.out.println(makeNegative(10));
        System.out.println(isPalindrome("oleelo"));
    }

    // Делаем число отрицательным
    public static int makeNegative(int num) {
        return num < 0 ? num : -num;
    }

    public static void formatCreditCard(long cardNumber) {
        String[] arrayCardNumber = String.valueOf(cardNumber).split("");
        String[] firstPartCardNumber = new String[4];
        String[] secondPartCardNumber = new String[4];
        String[] thirdPartCardNumber = secondPartCardNumber;
        String[] fourthPartCardNumber = new String[4];

        for (int i = 0; i < firstPartCardNumber.length; i++) {
            firstPartCardNumber[i] = arrayCardNumber[i];
            secondPartCardNumber[i] = "*";
            fourthPartCardNumber[i] = arrayCardNumber[i + 3 * 4];
        }
        System.out.println(Arrays.toString(firstPartCardNumber));
        System.out.println(Arrays.toString(secondPartCardNumber));
        System.out.println(Arrays.toString(thirdPartCardNumber));
        System.out.println(Arrays.toString(fourthPartCardNumber));
    }

    // Проверка на палиндром
    public static boolean isPalindrome(String string) {
        return string.equals(String.valueOf(new StringBuilder(string).reverse()));
    }
}