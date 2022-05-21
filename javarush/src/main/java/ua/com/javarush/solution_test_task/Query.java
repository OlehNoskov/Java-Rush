package ua.com.javarush.solution_test_task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Query extends BaseQuery {

    static final List<Query> listValidRequest = new ArrayList<>();

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

        listValidRequest.add(query);
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