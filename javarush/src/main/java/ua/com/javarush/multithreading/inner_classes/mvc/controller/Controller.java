package ua.com.javarush.multithreading.inner_classes.mvc.controller;

import ua.com.javarush.multithreading.inner_classes.mvc.model.Model;
import ua.com.javarush.multithreading.inner_classes.mvc.view.UsersView;

public class Controller {

    private Model model;
    private UsersView usersView;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void onShowAllUsers(){
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }
}