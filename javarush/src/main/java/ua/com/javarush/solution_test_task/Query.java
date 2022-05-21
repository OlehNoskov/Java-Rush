package ua.com.javarush.solution_test_task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Query implements BaseQuery {

    static final List<Query> listValidRequest = new ArrayList<>();

    static final String SYMBOL_QUERY = "D";

    private  String serviceId;
    private  String variationId;
    private  String questionTypeId;
    private  String categoryId;
    private  String subCategoryId;

    private  String typeAnswer;

    private  Date searchDateFrom;
    private  Date searchDateUpTo;

    public static void parsingString(String query) {
        String[] parts = query.split(" ");
        Query query1 = new Query();
        for (String part : parts) {
            String[] subParts = query.split("\\.");
            query1.setServiceId(subParts[0]);
            listValidRequest.add(query1);
        }
    }

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

    public void setSearchDateFrom(Date searchDateFrom) {
        this.searchDateFrom = searchDateFrom;
    }

    public void setSearchDateUpTo(Date searchDateUpTo) {
        this.searchDateUpTo = searchDateUpTo;
    }

    @Override
    public int getService(String[] query) {
        return 0;
    }

    @Override
    public int getVariation(String[] query) {
        return 0;
    }

    @Override
    public int getQuestionType(String[] query) {
        return 0;
    }

    @Override
    public int getCategory(String[] query) {
        return 0;
    }

    @Override
    public int getSubCategory(String[] query) {
        return 0;
    }

    @Override
    public int getDateFrom() {
        return 0;
    }

    @Override
    public int getDateUpTo() {
        return 0;
    }
}