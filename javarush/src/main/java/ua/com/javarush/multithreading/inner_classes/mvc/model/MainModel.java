package ua.com.javarush.multithreading.inner_classes.mvc.model;


import ua.com.javarush.multithreading.inner_classes.mvc.bean.User;
import ua.com.javarush.multithreading.inner_classes.mvc.model.service.UserService;
import ua.com.javarush.multithreading.inner_classes.mvc.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model{

    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> users = userService.getUsersBetweenLevels(1,100);
        modelData.setUsers(users);
    }
}