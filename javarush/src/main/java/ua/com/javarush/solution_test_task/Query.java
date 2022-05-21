package ua.com.javarush.solution_test_task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Query extends BaseQuery {

    static final List<Query> listValidRequest = new ArrayList<>();

    static final String SYMBOL_QUERY = "D";

    private Date searchDateFrom;
    private Date searchDateUpTo;

    public static void parsingString(String query) {
        Query query1 = new Query();
        query1.setService(query);
        query1.setVariation(query);
        query1.setQuestionType(query);
        query1.setCategory(query);
        query1.setSubCategory(query);
        query1.setTypeAnswer(query);

        listValidRequest.add(query1);
    }

    public void setSearchDateFrom(Date searchDateFrom) {
        this.searchDateFrom = searchDateFrom;
    }

    public void setSearchDateUpTo(Date searchDateUpTo) {
        this.searchDateUpTo = searchDateUpTo;
    }

    public Date getSearchDateFrom() {
        return searchDateFrom;
    }

    public Date getSearchDateUpTo() {
        return searchDateUpTo;
    }
}