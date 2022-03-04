package ua.com.javarush.multithreading.inner_classes.mvc.model;

import ua.com.javarush.multithreading.inner_classes.mvc.bean.User;
import ua.com.javarush.multithreading.inner_classes.mvc.model.service.UserService;
import ua.com.javarush.multithreading.inner_classes.mvc.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {

    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> users = getAllUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(false);
    }

    @Override
    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long userId) {
        userService.deleteUser(userId);
        List<User> users = getAllUsers();
        modelData.setUsers(users);
    }

    @Override
    public void changeUserData(String name, long userId, int level) {
       userService.createOrUpdateUser(name, userId, level);
       List<User> users = getAllUsers();
       modelData.setUsers(users);
    }

    private List<User> getAllUsers() {
        List<User> allUsers = userService.getUsersBetweenLevels(1, 100);
        allUsers = userService.filterOnlyActiveUsers(allUsers);
        return allUsers;
    }
}