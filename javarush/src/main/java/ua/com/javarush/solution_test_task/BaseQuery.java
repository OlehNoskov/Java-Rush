package ua.com.javarush.solution_test_task;

public abstract class BaseQuery {

    private String service;
    private String variation;
    private String questionType;
    private String category;
    private String subCategory;
    private String typeAnswer;
    private static String date;

    public static String[] getLineArray(String query) {
        return query.trim().split(" ");
    }

    public void setService(String line) {
        this.service = getLineArray(line)[1].split("\\.")[0];
    }

    public void setVariation(String line) {
        this.variation = "";
        if (getLineArray(line)[1].split("\\.").length > 1) {
            this.variation = getLineArray(line)[1].split("\\.")[1];
        }
    }

    public void setQuestionType(String line) {
        this.questionType = getLineArray(line)[2].split("\\.")[0];
    }

    public void setCategory(String line) {
        this.category = "";
        if (getLineArray(line)[2].split("\\.").length > 1) {
            this.category = getLineArray(line)[2].split("\\.")[1];
        }
    }

    public void setSubCategory(String line) {
        this.subCategory = "";
        if (getLineArray(line)[2].split("\\.").length > 2) {
            this.subCategory = getLineArray(line)[2].split("\\.")[2];
        }
    }

    public void setTypeAnswer(String line) {
        this.typeAnswer = getLineArray(line)[3];
    }

    public static String getDate(String line) {
        return getLineArray(line)[4];
    }

    public String getService() {
        return service;
    }

    public String getVariation() {
        return variation;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public String getTypeAnswer() {
        return typeAnswer;
    }
}