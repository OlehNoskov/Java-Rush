package ua.com.javarush.solution_test_task;

public interface BaseQuery {

    String getService(String[] query);
    String getVariation(String[] query);
    String getQuestionType(String[] query);
    String getCategory(String[] query);
    String getSubCategory(String[] query);
    String getDateFrom();
    String getDateUpTo();
}