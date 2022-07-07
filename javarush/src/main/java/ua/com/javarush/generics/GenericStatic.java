package ua.com.javarush.generics;

public class GenericStatic {

    // созлание дженерика в методе
    public static <T> T someStaticMethod(T genericObject) {
        System.out.println(genericObject);
        return genericObject;
    }
}