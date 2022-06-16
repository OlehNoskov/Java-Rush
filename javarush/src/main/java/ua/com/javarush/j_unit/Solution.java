package ua.com.javarush.j_unit;

public class Solution {
    public static void main(String[] args) {
        new User("Евгений", 35, Sex.MALE);
        new User("Марина", 34, Sex.FEMALE);
        new User("Арина", 7, Sex.FEMALE);

        System.out.println("Все пользователи:");
        User.getAllUsers().forEach(System.out::println);
        System.out.println("Все пользователи мужчины:");
        User.getAllUsers(Sex.MALE).forEach(System.out::println);
        System.out.println("Все пользователи женщины:");
        User.getAllUsers(Sex.FEMALE).forEach(System.out::println);
        System.out.println("=========================");
        System.out.println("Количество всех пользователей:" + User.getHowManyUsers());
        System.out.println("Количество всех мужчин:" + User.getHowManyUsers(Sex.MALE));
        System.out.println("Количество всех женщин:" + User.getHowManyUsers(Sex.FEMALE));
        System.out.println("==========================");
        System.out.println("Общий возраст всех пользователей:" + User.getAllAgeUsers());
        System.out.println("Общий возраст всех мужчин:"+ User.getAllAgeUsers(Sex.MALE));
        System.out.println("Общий возраст всех женщин:"+ User.getAllAgeUsers(Sex.FEMALE));
        System.out.println("==========================");
        System.out.println("Средний возраст всех пользователей:" + User.getAverageAgeOfAllUsers());
        System.out.println("Средний возраст всех мужчин:" + User.getAverageAgeOfAllUsers(Sex.MALE));
        System.out.println("Средний возраст всех женщин:" + User.getAverageAgeOfAllUsers(Sex.FEMALE));

    }
}
