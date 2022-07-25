package ua.com.javarush.exception.factory_exception;


public class Solution {

    public static Class getFactoryClass() {
        return FactoryExceptions.class;
    }

    public static void main(String[] args) {
        System.out.println(FactoryExceptions.getException(DatabaseExceptionMessage.NO_RESULT_DUE_TO_TIMEOUT));
    }
}