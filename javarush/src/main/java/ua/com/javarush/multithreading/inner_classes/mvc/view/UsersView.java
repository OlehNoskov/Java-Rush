package ua.com.javarush.multithreading.inner_classes.mvc.view;

import ua.com.javarush.multithreading.inner_classes.mvc.bean.User;
import ua.com.javarush.multithreading.inner_classes.mvc.controller.Controller;
import ua.com.javarush.multithreading.inner_classes.mvc.model.ModelData;

public class UsersView implements View {

    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("All " + (modelData.isDisplayDeletedUserList() ? "deleted " : "") + "users:");
        for (User user : modelData.getUsers()) {
            System.out.println("\t" + user);
        }
        System.out.println("===================================================");
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }
}