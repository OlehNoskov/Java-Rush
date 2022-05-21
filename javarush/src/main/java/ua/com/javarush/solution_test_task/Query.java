package ua.com.javarush.solution_test_task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Query extends BaseQuery {

    static final List<Query> listValidRequest = new ArrayList<>();
    static final List<String> getResult = new ArrayList<>();

    static final String SYMBOL_QUERY = "D";

    private Date searchDateFrom;
    private Date searchDateUpTo;

    public static void parsingString(String line) {
        Query query = new Query();
        query.setService(line);
        query.setVariation(line);
        query.setQuestionType(line);
        query.setCategory(line);
        query.setSubCategory(line);
        query.setTypeAnswer(line);
        query.setSearchDateFrom(line);
        query.setSearchDateUpTo(line);

        listValidRequest.add(query);
    }

    public void setSearchDateFrom(String searchDateFrom) {
        this.searchDateFrom = DateFromLine.getDateStartQuery(searchDateFrom);
    }

    public void setSearchDateUpTo(String searchDateUpTo) {
        this.searchDateUpTo = DateFromLine.getDateEndQuery(searchDateUpTo);
    }

    public Date getSearchDateFrom() {
        return searchDateFrom;
    }

    public Date getSearchDateUpTo() {
        return searchDateUpTo;
    }

    static void resultWaitingTime(List<Integer> waitingTime) {
        String result;
        int sum = 0;
        if (!waitingTime.isEmpty()) {
            for (Integer time : waitingTime) {
                sum += time;
            }
            sum = sum / waitingTime.size();
            result = "" + sum;
        } else {
            result = "-";
        }
        getResult.add(result);
    }
}