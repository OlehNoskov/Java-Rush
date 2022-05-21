package ua.com.javarush.solution_test_task;

public interface BaseQuery {

    int getService(String[] query);
    int getVariation(String[] query);
    int getQuestionType(String[] query);
    int getCategory(String[] query);
    int getSubCategory(String[] query);
    int getDateFrom();
    int getDateUpTo();
}
