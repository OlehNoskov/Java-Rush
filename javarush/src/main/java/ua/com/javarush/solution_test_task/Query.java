package ua.com.javarush.solution_test_task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Query extends BaseQuery{

    static final List<Query> listValidRequest = new ArrayList<>();
    static List<String> array = new ArrayList<>();

    static final String SYMBOL_QUERY = "D";

    private Date searchDateFrom;
    private Date searchDateUpTo;

    public static void parsingString(String query) {
            String[] parts = query.split(" ");
            for (String queryPart : parts) {
                String[] subParts = queryPart.split("\\.");
                for (String part: subParts) {
                    array.add(part);
                }
                listValidRequest.add(test(array));
//                array.clear();

            }
//        listValidRequest.add(test(array));
        }

    public static Query test(List<String> array) {
        Query query = new Query();
        query.setServiceId(array.get(1));
        query.setVariationId(array.get(2));
        query.setQuestionTypeId(array.get(3));
        query.setCategoryId(array.get(4));
        query.setSubCategoryId(array.get(5));
        return query;
    }

    public void setSearchDateFrom(Date searchDateFrom) {
        this.searchDateFrom = searchDateFrom;
    }

    public void setSearchDateUpTo(Date searchDateUpTo) {
        this.searchDateUpTo = searchDateUpTo;
    }
}