package ua.com.javarush.solution_test_task;

public abstract class BaseQuery {

    private String service;
    private String variation;
    private String questionType;
    private String category;
    private String subCategory;
    private String typeAnswer;
    static String EMPTY_DATA = "";

    static final int ZERO_INDEX = 0;
    static final int FIRST_INDEX = 1;
    static final int SECOND_INDEX = 2;
    static final int THIRD_INDEX = 3;
    static final int FOURTH_INDEX = 4;

    void setService(String line) {
        this.service = getLineArray(line)[FIRST_INDEX].split("\\.")[ZERO_INDEX];
    }

    String getService() {
        return service;
    }

    void setVariation(String line) {
        this.variation = EMPTY_DATA;
        if (getLineArray(line)[FIRST_INDEX].split("\\.").length > 1) {
            this.variation = getLineArray(line)[FIRST_INDEX].split("\\.")[FIRST_INDEX];
        }
    }

    String getVariation() {
        return variation;
    }

    void setQuestionType(String line) {
        this.questionType = getLineArray(line)[SECOND_INDEX].split("\\.")[ZERO_INDEX];
    }

    String getQuestionType() {
        return questionType;
    }

    void setCategory(String line) {
        this.category = EMPTY_DATA;
        if (getLineArray(line)[SECOND_INDEX].split("\\.").length > 1) {
            this.category = getLineArray(line)[SECOND_INDEX].split("\\.")[FIRST_INDEX];
        }
    }

    String getCategory() {
        return category;
    }

    public void setSubCategory(String line) {
        this.subCategory = EMPTY_DATA;
        if (getLineArray(line)[SECOND_INDEX].split("\\.").length > 2) {
            this.subCategory = getLineArray(line)[SECOND_INDEX].split("\\.")[SECOND_INDEX];
        }
    }

    String getSubCategory() {
        return subCategory;
    }

    void setTypeAnswer(String line) {
        this.typeAnswer = getLineArray(line)[THIRD_INDEX];
    }

    String getTypeAnswer() {
        return typeAnswer;
    }

    static String[] getLineArray(String query) {
        return query.trim().split(" ");
    }

    static String getDate(String line) {
        return getLineArray(line)[FOURTH_INDEX];
    }
}