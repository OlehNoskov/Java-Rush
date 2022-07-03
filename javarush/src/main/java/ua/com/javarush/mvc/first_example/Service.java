package ua.com.javarush.mvc.first_example;

import java.util.ArrayList;
import java.util.List;

public class Service {
    public List<String> getData() {
        List<String> data = new ArrayList<>() {{
            add("First string");
            add("Second string");
            add("Third string");
        }};
        return data;
    }
}