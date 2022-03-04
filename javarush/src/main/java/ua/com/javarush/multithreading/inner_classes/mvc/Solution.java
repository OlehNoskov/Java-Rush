package ua.com.javarush.multithreading.inner_classes.mvc;

import ua.com.javarush.multithreading.inner_classes.mvc.controller.Controller;
import ua.com.javarush.multithreading.inner_classes.mvc.model.MainModel;
import ua.com.javarush.multithreading.inner_classes.mvc.model.Model;
import ua.com.javarush.multithreading.inner_classes.mvc.view.EditUserView;
import ua.com.javarush.multithreading.inner_classes.mvc.view.UsersView;

public class Solution {

    public static void main(String[] args) {

        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();

        usersView.setController(controller);
        editUserView.setController(controller);

        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126L);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("Oleg", 126L, 5);
        usersView.fireEventShowDeletedUsers();
    }
}