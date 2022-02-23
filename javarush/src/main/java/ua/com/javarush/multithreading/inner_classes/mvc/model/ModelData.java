package ua.com.javarush.multithreading.inner_classes.mvc.model;

import ua.com.javarush.multithreading.inner_classes.mvc.bean.User;

import java.util.List;

public class ModelData {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}