package ua.com.javarush.exception;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 Непроверяемые исключения (unchecked exception)
 */

public class VeryComplexClassUnchecked {
    public void methodThrowsClassCastException() {
        List<Integer> list = new ArrayList<Integer>();
        ((LinkedList<Integer>) list).add(3);
    }

    public void methodThrowsNullPointerException() {
        int[] arr = null;
        int i = arr.length;
    }

    public static void main(String[] args) {

    }
}