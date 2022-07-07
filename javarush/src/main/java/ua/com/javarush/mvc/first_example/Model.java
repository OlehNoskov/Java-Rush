package ua.com.javarush.mvc.first_example;

import java.util.List;

public class Model {
    private Service service = new Service();

    public List<String> getStringDataList() {
        return service.getData();
    }
}