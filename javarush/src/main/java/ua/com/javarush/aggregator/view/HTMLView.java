package ua.com.javarush.aggregator.view;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ua.com.javarush.aggregator.Controller;
import ua.com.javarush.aggregator.value_object.Vacancy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

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
        try {
            Document doc = getDocument();
            // get all classes template
            Elements templateHidden = doc.getElementsByClass("template");
            // get first element class template
            Element template = templateHidden.clone().removeAttr("style").removeClass("template").get(0);

            //remove all prev vacancies
            Elements prevVacancies = doc.getElementsByClass("vacancy");

            for (Element redundant : prevVacancies) {
                if (!redundant.hasClass("template")) {
                    redundant.remove();
                }
            }

            //add new vacancies
            for (Vacancy vacancy : vacancies) {
                Element vacancyElement = template.clone();

                Element vacancyLink = vacancyElement.getElementsByAttribute("href").get(0);
                vacancyLink.appendText(vacancy.getTitle());

                vacancyLink.attr("href", vacancy.getUrl());
                Element city = vacancyElement.getElementsByClass("city").get(0);

                city.appendText(vacancy.getCity());
                Element companyName = vacancyElement.getElementsByClass("companyName").get(0);
                companyName.appendText(vacancy.getCompanyName());

                Elements salaryEls = vacancyElement.getElementsByClass("salary");
                Element salary = salaryEls.get(0);
                salary.appendText(vacancy.getSalary());

                templateHidden.before(vacancyElement.outerHtml());
            }
            return doc.html();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Some exception occurred";
    }

    private void updateFile(String string) {
        File file = new File(filePath);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(string.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}