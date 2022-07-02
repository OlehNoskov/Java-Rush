package ua.com.javarush.generics.list_to_map;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

public class ConvertableUtil {
    //    public static Map convert(List<? extends Convertable> list) {
//        Map result = new HashMap();
//        for (Convertable element: list){
//            result.put(element.getKey(), element);
//        }
//        return result;
//    }
    public static <Key, E extends Convertable<Key>> Map<Key, E> convert(List<E> list) {
        Map<Key, E> result = new HashMap();
        for (E element : list) {
            Key key = element.getKey();
            result.put(key, element);
        }
        return result;
    }
}