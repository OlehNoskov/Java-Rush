package ua.com.javarush.multithreading.inner_classes.mvc.controller;

import ua.com.javarush.multithreading.inner_classes.mvc.model.Model;

public class Controller {

    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    void onShowAllUsers(){
        model.loadUsers();
    }
}