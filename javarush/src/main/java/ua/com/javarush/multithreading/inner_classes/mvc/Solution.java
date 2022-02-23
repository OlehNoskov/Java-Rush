package ua.com.javarush.multithreading.inner_classes.mvc;

import ua.com.javarush.multithreading.inner_classes.mvc.controller.Controller;
import ua.com.javarush.multithreading.inner_classes.mvc.model.MainModel;
import ua.com.javarush.multithreading.inner_classes.mvc.model.Model;
import ua.com.javarush.multithreading.inner_classes.mvc.view.UsersView;

public class Solution {

    public static void main(String[] args) {

        Model model = new MainModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();

        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventShowDeletedUsers();
    }
}