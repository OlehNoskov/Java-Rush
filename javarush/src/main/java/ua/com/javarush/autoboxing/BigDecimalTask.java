package ua.com.javarush.autoboxing;

import java.math.BigDecimal;

public class BigDecimalTask {
    public static void main(String[] args) {
        System.out.println(getValue(1.1d, 1.2d));
    }

    public static BigDecimal getValue(double v1, double v2) {
        // add метод сложения 2 чисел
        // Было так
        // return new BigDecimal(v1).add(new BigDecimal(v2));
        // result = 2.3000000000000000444089209850062616169452667236328125

        return new BigDecimal(String.valueOf(v1)).add(new BigDecimal(String.valueOf(v2)));
    }
}