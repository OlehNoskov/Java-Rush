package ua.com.javarush.aggregator.view;

import ua.com.javarush.aggregator.Controller;
import ua.com.javarush.aggregator.value_object.Vacancy;

import java.util.List;

public interface View {
    void update(List<Vacancy> vacancies);
    void setController(Controller controller);
}