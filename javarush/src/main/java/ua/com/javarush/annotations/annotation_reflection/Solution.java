package ua.com.javarush.annotations.annotation_reflection;

public class Solution {

    /** Ожидаемый вывод:

     Проверка №1:
     Поле amount в классе JavaRushBankAccount имеет аннотацию LongPositive, но его значение не положительное.
     Проверка №2:
     Проверка №3:
     Поле amountString в классе IncorrectAccount имеет аннотацию LongPositive, но его тип String.

     */
    public static void main(String[] args) throws IllegalAccessException {
        JavaRushBankAccount account = new JavaRushBankAccount("Mr.Smith");
        System.out.println("Проверка №1:");
        ReflectionAnnotationUtil.check(account);

        System.out.println("Проверка №2:");
        account.setAmount(100);
        ReflectionAnnotationUtil.check(account);

        System.out.println("Проверка №3:");
        ReflectionAnnotationUtil.check(new IncorrectAccount());
    }
}