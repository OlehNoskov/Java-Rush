package ua.com.javarush.exception;

/**
 Проверяемые исключения (checked exception)
 */

public class VeryComplexClassChecked {
    public void veryComplexMethod() throws Exception {
        this.clone();
    }

    public static void main(String[] args) throws Exception {
        VeryComplexClassChecked veryComplexClass = new VeryComplexClassChecked();
        veryComplexClass.veryComplexMethod();
    }
}