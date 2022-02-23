package ua.com.javarush.multithreading.inner_classes.mvc.model.service;

import ua.com.javarush.multithreading.inner_classes.mvc.bean.User;

import java.util.List;

public interface UserService {

    public User deleteUser(long id);

    public User createOrUpdateUser(String name, long id, int level);

    public List<User> getUsersByName(String name);

    public List<User> getAllDeletedUsers();

    public List<User> getUsersBetweenLevels(int fromLevel, int toLevel);

    List<User> filterOnlyActiveUsers(List<User> allUsers);

    User getUsersById(long userId);
}