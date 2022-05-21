package ua.com.javarush.solution_test_task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeLine implements BaseTimeLine {

    static final List<TimeLine> listValidWaitTimeline = new ArrayList<>();

    static final String SYMBOL_QUERY = "C";

    private String serviceId;
    private String variationId;
    private String questionTypeId;
    private String categoryId;
    private String subCategoryId;
    private String waitTime;

    private String typeAnswer;

    private Date searchTimeFrom;

    public static void parsingString(String query) {
        String[] parts = query.split(" ");
        TimeLine timeLine = new TimeLine();
        for (String queryPart : parts) {
            String[] subParts = queryPart.split("\\.");
            for (String part: subParts) {
                timeLine.setServiceId(part);
//                query1.setVariationId(part);
//                query1.setQuestionTypeId(part);
//                query1.setCategoryId(part);
//                query1.setSubCategoryId(part);
                listValidWaitTimeline.add(timeLine);
            }
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

    public void setWaitTime(String waitTime) {
        this.waitTime = waitTime;
    }

    public void setTypeAnswer(String typeAnswer) {
        this.typeAnswer = typeAnswer;
    }

    public void setSearchTimeFrom(Date searchTimeFrom) {
        this.searchTimeFrom = searchTimeFrom;
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
    public int getDate() {
        return 0;
    }

    @Override
    public int getWaitTime() {
        return 0;
    }

    static int getResultWaitingTime(List<Integer> waitingTime) {
        int result = 0;
        if (!waitingTime.isEmpty()) {
            for (Integer time : waitingTime) {
                result += time;
            }
            result = result / waitingTime.size();
        }
        return result;
    }

//    static int getWaitingTime(String query) {
//        return Integer.parseInt(QueryStringData.getLineArray(query)[getLastIndexArray(query)]);
//    }

//    private static int getLastIndexArray(String query) {
//        return QueryStringData.getLineArray(query).length - 1;
//    }


    @Override
    public String toString() {
        return "TimeLine{" +
                "serviceId=" + serviceId +
                ", variationId=" + variationId +
                ", questionTypeId=" + questionTypeId +
                ", categoryId=" + categoryId +
                ", subCategoryId=" + subCategoryId +
                ", waitTime=" + waitTime +
                ", typeAnswer='" + typeAnswer + '\'' +
                ", searchTimeFrom=" + searchTimeFrom +
                '}';
    }
}