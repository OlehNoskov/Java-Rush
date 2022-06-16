package ua.com.javarush.j_unit;

import java.util.*;

public class User {
    private static int countId = 0;
    private int id;
    private String name;
    private int age;
    private Sex sex;

    private static Map<Integer, User> allUsers = new HashMap<>();

    public User(String name, int age, Sex sex) {

        this.name = name;
        this.age = age;
        this.sex = sex;

        if (!hasUser()) {
            countId++;
            this.id = countId;
            allUsers.put(id, this);
        }
    }

    private boolean hasUser() {
        for (User user : allUsers.values()) {
            if (user.equals(this) && user.hashCode() == this.hashCode()) {
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    //список всех юзеров
    public static List<User> getAllUsers() {
        return new ArrayList<>(allUsers.values());
    }

    //список всех юзеров в зависимости от пола
    public static List<User> getAllUsers(Sex sex) {
        List<User> listAllUsers = new ArrayList<>();
        for (User user : allUsers.values()) {
            if (user.sex == sex) {
                listAllUsers.add(user);
            }
        }
        return listAllUsers;
    }

    //Количество всех юзеров
    public static int getHowManyUsers() {
        return getAllUsers().size();
    }

    //Количество всех юзеров в зависимости от пола
    public static int getHowManyUsers(Sex sex) {
        return getAllUsers(sex).size();
    }


    //общая сумма по возрасту пользователей
    public static int getAllAgeUsers() {
        int countAge = 0;
        for (User user : getAllUsers()) {
            countAge += user.age;
        }
        return countAge;
    }

    //общая сумма по возрасту пользователей в зависимости от пола
    public static int getAllAgeUsers(Sex sex) {
        int countAge = 0;
        for (User user : getAllUsers(sex)) {
            countAge += user.age;
        }
        return countAge;
    }

    //Средний возраст пользователей
    public static int getAverageAgeOfAllUsers(){
        return getAllAgeUsers()/getHowManyUsers();
    }

    //Средний возраст пользователей в зависимости от пола
    public static int getAverageAgeOfAllUsers(Sex sex){
        return getAllAgeUsers(sex)/getHowManyUsers(sex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(sex, user.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, sex);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}