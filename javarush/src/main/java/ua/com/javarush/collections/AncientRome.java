package ua.com.javarush.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Map;

public class AncientRome {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        int output = 0;

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        if (s.length() == 0) return 0;
        if (s.length() == 1) return map.get(String.valueOf(s.charAt(0)));

        for (int i = 0; i < (s.length() - 1); i++) {
            if (map.get(String.valueOf(s.charAt(i))) >=
                    map.get(String.valueOf(s.charAt(i + 1)))) {
                output = output + map.get(String.valueOf(s.charAt(i)));
            } else {
                output = output - map.get(String.valueOf(s.charAt(i)));
            }
        }
        output = output + map.get(String.valueOf(s.charAt(s.length() - 1)));
        return output;
    }
}