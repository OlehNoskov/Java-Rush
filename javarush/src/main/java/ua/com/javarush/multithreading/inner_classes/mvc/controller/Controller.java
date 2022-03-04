package ua.com.javarush.multithreading.inner_classes.mvc.controller;

import ua.com.javarush.multithreading.inner_classes.mvc.model.Model;
import ua.com.javarush.multithreading.inner_classes.mvc.view.EditUserView;
import ua.com.javarush.multithreading.inner_classes.mvc.view.UsersView;

public class Controller {

    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    public void onShowAllUsers(){
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }

    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }

    public void onOpenUserEditForm(long userId){
        model.loadUserById(userId);
        editUserView.refresh(model.getModelData());
    }

    public void onUserDelete( long userId){
        model.deleteUserById(userId);
        usersView.refresh(model.getModelData());
    }

    public void onUserChange(String name, long userId, int level){
        model.changeUserData(name, userId, level);
        usersView.refresh(model.getModelData());
    }
}