package ua.com.javarush.autoboxing;

import java.util.Random;

public class ReplaceRecursion {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder stringBuilder = new StringBuilder();
        if (a > b) {
            for (int i = b; i <= a; i++) {
                stringBuilder.append(i).append(" ");
            }
        } else if (a < b) {
            for (int i = b; i >= a; i--) {
                stringBuilder.append(i).append(" ");
            }
        } else {
            stringBuilder.append(a);
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}