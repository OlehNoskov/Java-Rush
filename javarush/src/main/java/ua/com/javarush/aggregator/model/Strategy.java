package ua.com.javarush.aggregator.model;

import ua.com.javarush.aggregator.value_object.Vacancy;

import java.io.IOException;
import java.util.List;

/**
 * Отвечает за получение данных с сайта
 */

public interface Strategy {
    List<Vacancy> getVacancies(String searchString) throws IOException;
}