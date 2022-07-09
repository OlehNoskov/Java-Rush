package ua.com.javarush.strategy_pattern;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Helper {

    public static String generateRandomString() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

//    private static final String CHAR_LOWER_AND_NUMBER = "abcdefghijklmnopqrstuvwxyz0123456789";
//    private static final Random random = new SecureRandom();
//    private static char[] buf = new char[CHAR_LOWER_AND_NUMBER.length()];;
//
//    public static String generateRandomString() {
//        for (int i = 0; i < buf.length; i++) {
//            buf[i] = CHAR_LOWER_AND_NUMBER.charAt(random.nextInt(CHAR_LOWER_AND_NUMBER.length()));
//        }
//        return new String(buf);
//    }
//
//    public static void printMessage(String message) {
//        System.out.println(message);
//    }
}