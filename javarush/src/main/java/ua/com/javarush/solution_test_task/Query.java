package ua.com.javarush.solution_test_task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Query extends BaseQuery {

    static final List<Query> listValidRequest = new ArrayList<>();
    static final List<String> listAverageWaitingTime = new ArrayList<>();

    static final String SYMBOL_QUERY = "D";
    static final String SEARCH_ALL_TIMELINE = "*";

    private Date searchDateFrom;
    private Date searchDateUpTo;

    static void parsingString(String line) {
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

    void setSearchDateFrom(String searchDateFrom) {
        this.searchDateFrom = DateFromLine.getDateStartQuery(searchDateFrom);
    }

    void setSearchDateUpTo(String searchDateUpTo) {
        this.searchDateUpTo = DateFromLine.getDateEndQuery(searchDateUpTo);
    }

    Date getSearchDateFrom() {
        return searchDateFrom;
    }

    Date getSearchDateUpTo() {
        return searchDateUpTo;
    }

    static void getResultWaitingTime() {
        String result;
        int sum = 0;

        if (!SearchQuery.listWaitTime.isEmpty()) {
            for (Integer time : SearchQuery.listWaitTime) {
                sum += time;
            }
            sum = sum / SearchQuery.listWaitTime.size();
            result = "" + sum;
        } else {
            result = "-";
        }
        listAverageWaitingTime.add(result);
    }
}