package ua.com.javarush.annotations.processing_annotation;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        boolean result = false;
        // Проверяет, если ли у класса нужная аннотация
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            result = true;

            // Возвращает обьект аннотацию, если такая у класса есть
            PrepareMyTest myTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (String s : myTest.fullyQualifiedNames()) {
                System.out.println(s);
            }
        }
        return result;
    }

    public static boolean printValues(Class c) {
        boolean result = false;
        // Проверяет, если ли у класса нужная аннотация
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            result = true;

            // Возвращает обьект аннотацию, если такая у класса есть
            PrepareMyTest myTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (Class clazz : myTest.value()) {
                System.out.println(clazz.getSimpleName());
            }
        }
        return result;
    }
}