package ua.com.javarush.aggregator.model;

import lombok.Setter;
import ua.com.javarush.aggregator.value_object.Vacancy;

import java.io.IOException;
import java.util.List;

/**
 * Класс обобщает получение данных о вакансиях
 * Выступаяет в качестве контекста (паттерн Strategy)
 */

@Setter
public class Provider {
    private Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Vacancy> getJavaVacancies(String searchString) {
        try {
            return strategy.getVacancies(searchString);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}