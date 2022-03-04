package ua.com.javarush.multithreading.inner_classes.mvc.view;

import ua.com.javarush.multithreading.inner_classes.mvc.bean.User;
import ua.com.javarush.multithreading.inner_classes.mvc.controller.Controller;
import ua.com.javarush.multithreading.inner_classes.mvc.model.ModelData;

import java.util.List;

public class EditUserView implements View {

    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited!");
        List<User> users = modelData.getUsers();

        for (User user : users) {
            System.out.println("\t" + user);
        }
        System.out.println("=========================");
    }
}
