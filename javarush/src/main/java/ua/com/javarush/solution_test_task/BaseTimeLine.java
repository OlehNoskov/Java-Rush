package ua.com.javarush.solution_test_task;

public interface BaseTimeLine {

    int getService(String[] query);
    int getVariation(String[] query);
    int getQuestionType(String[] query);
    int getCategory(String[] query);
    int getSubCategory(String[] query);
    int getDate();
    int getWaitTime();
}
