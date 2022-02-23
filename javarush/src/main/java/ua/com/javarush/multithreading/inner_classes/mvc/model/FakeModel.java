package ua.com.javarush.multithreading.inner_classes.mvc.model;

import ua.com.javarush.multithreading.inner_classes.mvc.bean.User;

import java.util.LinkedList;
import java.util.List;

public class FakeModel implements Model {

    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
           List<User> users = new LinkedList<User>();
           users.add(new User("A", 1L,1));
           users.add(new User("B", 2L,1));
           modelData.setUsers(users);
    }
}