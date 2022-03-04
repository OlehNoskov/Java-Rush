package ua.com.javarush.multithreading.inner_classes.mvc.model;

public interface Model {

    ModelData getModelData();

    void loadUsers();

    void loadDeletedUsers();

    void loadUserById(long userId);

    void deleteUserById(long userId);
}