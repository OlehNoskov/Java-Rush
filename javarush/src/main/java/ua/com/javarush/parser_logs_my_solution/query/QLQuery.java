package ua.com.javarush.parser_logs_my_solution.query;

import java.util.Set;

/**
 * Custom language query
 */

public interface QLQuery {
    Set<Object> execute(String query);
}