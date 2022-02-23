package ua.com.javarush.multithreading.inner_classes.mvc.view;

import ua.com.javarush.multithreading.inner_classes.mvc.controller.Controller;
import ua.com.javarush.multithreading.inner_classes.mvc.model.ModelData;

public interface View {

    void refresh(ModelData modelData);

    void setController(Controller controller);
}