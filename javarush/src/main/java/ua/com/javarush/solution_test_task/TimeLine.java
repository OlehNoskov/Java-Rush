package ua.com.javarush.solution_test_task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeLine extends BaseQuery {

    static final List<TimeLine> listValidWaitTimeline = new ArrayList<>();

    static final String SYMBOL_QUERY = "C";

    private int waitTime;

    private Date createTimeline;

    public static void parsingString(String line) {
        TimeLine timeLine = new TimeLine();
        timeLine.setService(line);
        timeLine.setVariation(line);
        timeLine.setQuestionType(line);
        timeLine.setCategory(line);
        timeLine.setSubCategory(line);
        timeLine.setTypeAnswer(line);
        timeLine.setCreateTimeline(line);
        timeLine.setWaitTime(line);

        listValidWaitTimeline.add(timeLine);
    }

    public void setWaitTime(String line) {
        this.waitTime = Integer.parseInt(BaseQuery.getLineArray(line)[5]);
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setCreateTimeline(String line) {
        this.createTimeline = DateFromLine.getDateStartQuery(line);
    }

    public Date getCreateTimeline() {
        return createTimeline;
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
//
//    private static int getLastIndexArray(String query) {
//        return QueryStringData.getLineArray(query).length - 1;
//    }
}