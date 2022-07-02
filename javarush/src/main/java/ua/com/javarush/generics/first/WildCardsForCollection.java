package ua.com.javarush.generics.first;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WildCardsForCollection {
    public static void main(String[] args) {
    }

    public static  Double sum(List<? extends Number> list) {
        Double result = 0.0;
        for (int i = 0; i < list.size(); i++) {
            Number numb = list.get(i);
            result += numb.doubleValue();
        }
        return result;
    }

    public static Double multiply(List<? extends Number> list) {
        Double result = 1.0;
        for (int i = 0; i < list.size(); i++) {
            Number numb = (Number) list.get(i);
            result *= numb.doubleValue();
        }
        return result;
    }

    public static String concat(List<?> list) {
        StringBuilder builder = new StringBuilder();
        for (Object obj : list) {
            builder.append(obj);
        }
        return builder.toString();
    }

    public static List combine(List<? extends Collection> list) {
        List result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Collection collection = list.get(i);
            result.addAll(collection);
        }
        return result;
    }
}