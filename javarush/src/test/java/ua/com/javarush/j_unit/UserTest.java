package ua.com.javarush.j_unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UserTest {
    private User user1;
    private User user2;
    private User user3;

    //Данный метод будет вполняться перед всеми методами с тестами
    @Before
    public void setUp() throws Exception {
        //Создаем тестовые данные
        User user1 = new User("Евгений", 35, Sex.MALE);
        User user2 = new User("Марина", 34, Sex.FEMALE);
        User user3 = new User("Арина", 7, Sex.FEMALE);
    }

    @Test
    void getAllUsers() {

        //создаем список и заполняем его данными нашего метода
        List<User> expected = User.getAllUsers();

        //создаем список и заполняем его данными для сравнения
        //то что мы предполагаем метод должен вернуть
        List<User> actual = new ArrayList<>();
        actual.add(user1);
        actual.add(user2);
        actual.add(user3);

        //запускаем тест в случае если список expected и actual не будут равны
        //тест будет провален, результат в консоли
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getAllUsers_MALE() {

        //создаем список и заполняем его данными нашего метода
        List<User> expected = User.getAllUsers(Sex.MALE);

        //создаем список и заполняем его данными для сравнения
        //то что мы предполагаем метод должен вернуть
        List<User> actual = new ArrayList<>();
        actual.add(user1);

        //запускаем тест в случае если список expected и actual не будут равны
        //тест будет провален, результат в консоли
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getAllUsers_FEMALE() {

        //создаем список и заполняем его данными нашего метода
        List<User> expected = User.getAllUsers(Sex.FEMALE);

        //создаем список и заполняем его данными для сравнения
        //то что мы предполагаем метод должен вернуть
        List<User> actual = new ArrayList<>();
        actual.add(user2);
        actual.add(user3);

        //запускаем тест в случае если список expected и actual не будут равны
        //тест будет провален, результат в консоли
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getHowManyUsersMALE() {
        int expected = User.getHowManyUsers(Sex.MALE);
        int actual = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void getHowManyUsersFEMALE() {
        int expected = User.getHowManyUsers(Sex.FEMALE);
        int actual = 2;

        Assert.assertEquals(expected, actual);
    }


    @Test
    void getHowManyUsers() {
        int expected = User.getHowManyUsers();
        int actual = 3;

        Assert.assertEquals(expected, actual);
    }


    @Test
    void getAllAgeUsers() {
        int expected = User.getAllAgeUsers();
        int actual = 35 + 34 + 7;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void getAllAgeUsers_MALE() {
        int expected = User.getAllAgeUsers(Sex.MALE);
        int actual = 35;

        Assert.assertEquals(expected, actual);
    }

    @Test
    void getAllAgeUsers_FEMALE() {
        int expected = User.getAllAgeUsers(Sex.FEMALE);
        int actual = 34 + 7;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUser_NO_NULL() {
        //проверка на null
        List<User> expected = User.getAllUsers();
        Assert.assertNotNull(expected);
    }
}