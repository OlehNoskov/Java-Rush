package ua.com.javarush.multithreading.inner_classes.refactoring;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static List<Iterator> iterators = new LinkedList<>();

    private int countItems;

    //стало
    public Iterator getIterator(final String name) {
        return new Iterator() {
            {
                countItems++;
                System.out.println(name + " item " + countItems);
            }

            @Override
            public Iterator next() {
                return getIterator(name);
            }
        };
    }
//было
//    public Iterator getIterator(final String name) {
//        class LocalIterator implements Iterator {
//            public LocalIterator() {
//                countItems++;
//                System.out.println(name + " item " + countItems);
//            }
//
//            public Iterator next() {
//                return new LocalIterator();
//            }
//        }
//        return new LocalIterator();
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Iterator iterator = solution.getIterator("iterator");
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}