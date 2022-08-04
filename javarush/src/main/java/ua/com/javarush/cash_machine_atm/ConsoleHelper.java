package ua.com.javarush.cash_machine_atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс для взаимодейсвия с пользователем
 */

public class ConsoleHelper {
    private static final BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    static void writeMessage(String message) {
        System.out.println(message);
    }

    static String readString() {
        String result = null;
        try {
            result = bis.readLine();
        } catch (IOException e) {
            System.out.println("Something wrong!");
        }
        return result;
    }

    static String askCurrencyCode() {
        System.out.println("Please enter currency code: ");
        String currencyCode = readString();
        if (currencyCode.length() == 3) {
            currencyCode = currencyCode.toUpperCase();
        } else {
            System.out.println("Input currency code is incorrect! Please try again!");
            askCurrencyCode();
        }
        return currencyCode;
    }

    static String[] getValidTwoDigits(String currencyCode) {
        String[] result = new String[2];
        System.out.println("Please enter denomination: ");
        try {
            int denomination = Integer.parseInt(readString());
            if (denomination > 0) {
                result[0] = String.valueOf(denomination);
            }
        } catch (NumberFormatException e) {
            System.out.println("Input data is incorrect! Try again!");
            getValidTwoDigits(currencyCode);
        }
        System.out.println("Please enter count: ");
        try {
            int count = Integer.parseInt(readString());
            if (count > 0) {
                result[1] = String.valueOf(count);
            }
        } catch (NumberFormatException e) {
            System.out.println("Input data is incorrect! Try again!");
            getValidTwoDigits(currencyCode);
        }

        return result;
    }
}