package ua.com.javarush.solution_test_task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeLine extends BaseQuery {

    static final List<TimeLine> listValidTimeline = new ArrayList<>();

    static final String SYMBOL_QUERY = "C";

    private int waitTime;
    private int indexWaitTime = 5;

    private Date createTimeline;

    static void parsingString(String line) {
        TimeLine timeLine = new TimeLine();

        timeLine.setService(line);
        timeLine.setVariation(line);
        timeLine.setQuestionType(line);
        timeLine.setCategory(line);
        timeLine.setSubCategory(line);
        timeLine.setTypeAnswer(line);
        timeLine.setCreateTimeline(line);
        timeLine.setWaitTime(line);

        listValidTimeline.add(timeLine);
    }

    void setWaitTime(String line) {
        this.waitTime = Integer.parseInt(BaseQuery.getLineArray(line)[indexWaitTime]);
    }

    int getWaitTime() {
        return waitTime;
    }

    void setCreateTimeline(String line) {
        this.createTimeline = DateFromLine.getDateStartQuery(line);
    }

    Date getCreateTimeline() {
        return createTimeline;
    }
}