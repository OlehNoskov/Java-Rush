package ua.com.javarush.aggregator;

import ua.com.javarush.aggregator.model.HHStrategy;
import ua.com.javarush.aggregator.model.Model;
import ua.com.javarush.aggregator.model.Provider;
import ua.com.javarush.aggregator.view.HTMLView;

import java.io.IOException;

public class Aggregator {
    public static void main(String[] args) throws IOException {
        HTMLView view = new HTMLView();
        Model model = new Model(view, new Provider(new HHStrategy()));
        Controller controller = new Controller(model);

        view.setController(controller);
        view.userCitySelectEmulation();
    }
}