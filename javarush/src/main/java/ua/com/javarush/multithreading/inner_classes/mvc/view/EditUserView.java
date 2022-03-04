package ua.com.javarush.multithreading.inner_classes.mvc.view;

import ua.com.javarush.multithreading.inner_classes.mvc.controller.Controller;
import ua.com.javarush.multithreading.inner_classes.mvc.model.ModelData;

public class EditUserView implements View {

    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited!");
        System.out.println("\t"+modelData.getActiveUser());
        System.out.println("=========================");
    }

    public void fireEventUserDeleted(long userId){
        controller.onUserDelete(userId);
    }

    public void fireEventUserChanged(String name, long userId, int level){
        controller.onUserChange(name, userId, level);
    }
}