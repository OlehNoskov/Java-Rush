package ua.com.javarush.solution_test_task;

public abstract class BaseQuery {

    private String service;
    private String variation;
    private String questionType;
    private String category;
    private String subCategory;
    private String typeAnswer;
    private static String date;

    private int zeroIndex = 0;
    private int firstIndex = 1;
    private int secondIndex = 2;
    private int thirdIndex = 3;
    private static int fourthIndex = 4;

    public static String[] getLineArray(String query) {
        return query.trim().split(" ");
    }

    public void setService(String line) {
        this.service = getLineArray(line)[firstIndex].split("\\.")[zeroIndex];
    }

    public void setVariation(String line) {
        this.variation = "";
        if (getLineArray(line)[firstIndex].split("\\.").length > 1) {
            this.variation = getLineArray(line)[firstIndex].split("\\.")[firstIndex];
        }
    }

    public void setQuestionType(String line) {
        this.questionType = getLineArray(line)[secondIndex].split("\\.")[zeroIndex];
    }

    public void setCategory(String line) {
        this.category = "";
        if (getLineArray(line)[secondIndex].split("\\.").length > 1) {
            this.category = getLineArray(line)[secondIndex].split("\\.")[firstIndex];
        }
    }

    public void setSubCategory(String line) {
        this.subCategory = "";
        if (getLineArray(line)[secondIndex].split("\\.").length > 2) {
            this.subCategory = getLineArray(line)[secondIndex].split("\\.")[secondIndex];
        }
    }

    public void setTypeAnswer(String line) {
        this.typeAnswer = getLineArray(line)[thirdIndex];
    }

    public static String getDate(String line) {
        return getLineArray(line)[fourthIndex];
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

    @Override
    public String toString() {
        return "BaseQuery{" +
                "service='" + service + '\'' +
                ", variation='" + variation + '\'' +
                ", questionType='" + questionType + '\'' +
                ", category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", typeAnswer='" + typeAnswer + '\'' +
                '}';
    }
}