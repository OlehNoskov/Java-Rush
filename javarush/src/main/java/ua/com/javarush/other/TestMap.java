package ua.com.javarush.other;

import java.util.HashMap;
import java.util.Map;

 class TestMap {
    private static Map<User, String> users = new HashMap<>();

    public static void main(String[] args) {
            User user1 = new User(1, "Oleg", "Noskov");
            User user2 = new User(1, "Oleg", "Noskov");
            User user3 = new User(1, "Oleg", "Noskov");
            users.put(user1, "Trainee");
            users.put(user2, "Junior");
            users.put(user3, "Middle");

        System.out.println(users.get(user2));
        System.out.println(testFinally());
    }

    private static class User {
        int index;
        private String name;
        private String surname;

        public User(int index, String name, String surname) {
            this.index = index;
            this.name = name;
            this.surname = surname;
        }
    }

    private static int testFinally() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }
}