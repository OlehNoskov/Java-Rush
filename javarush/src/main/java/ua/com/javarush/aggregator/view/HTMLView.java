package ua.com.javarush.aggregator.view;

import ua.com.javarush.aggregator.Controller;
import ua.com.javarush.aggregator.value_object.Vacancy;

import java.util.List;

public class HTMLView implements View {
    private Controller controller;
    private final String filePath = "vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            String newContent = getUpdatedFileContent(vacancies);
            updateFile(newContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulation() {
        controller.onCitySelect("Kharkiv");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        return null;
    }

    private void updateFile(String string) {

    }
}