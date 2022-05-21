package ua.com.javarush.solution_test_task;

public abstract class BaseQuery {

    private String serviceId;
    private String variationId;
    private String questionTypeId;
    private String categoryId;
    private String subCategoryId;

    private String typeAnswer;

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public void setVariationId(String variationId) {
        this.variationId = variationId;
    }

    public void setQuestionTypeId(String questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public void setTypeAnswer(String typeAnswer) {
        this.typeAnswer = typeAnswer;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getVariationId() {
        return variationId;
    }

    public String getQuestionTypeId() {
        return questionTypeId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public String getTypeAnswer() {
        return typeAnswer;
    }
}