package ua.com.javarush.solution_test_task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeLine extends BaseQuery {

    static final List<TimeLine> listValidWaitTimeline = new ArrayList<>();

    static final String SYMBOL_QUERY = "C";

    private int waitTime;

    private Date searchTimeFrom;

    public int getWaitTime() {
        return waitTime;
    }

    public Date getSearchTimeFrom() {
        return searchTimeFrom;
    }

//    public static void parsingString(String query) {
//        String[] parts = query.split(" ");
//        TimeLine timeLine = new TimeLine();
//        for (String queryPart : parts) {
//            String[] subParts = queryPart.split("\\.");
//            for (String part: subParts) {
//                timeLine.setService(part);
////                query1.setVariationId(part);
////                query1.setQuestionTypeId(part);
////                query1.setCategoryId(part);
////                query1.setSubCategoryId(part);
//                listValidWaitTimeline.add(timeLine);
//            }
//        }
//    }

    public void setSearchTimeFrom(Date searchTimeFrom) {
        this.searchTimeFrom = searchTimeFrom;
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
}