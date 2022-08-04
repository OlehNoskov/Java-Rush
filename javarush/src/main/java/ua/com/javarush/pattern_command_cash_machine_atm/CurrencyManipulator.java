package ua.com.javarush.pattern_command_cash_machine_atm;

import java.util.Map;
import java.util.TreeMap;

/**
 * Класс хранит информацию о выбранной валюте
 */

public class CurrencyManipulator {
    // Код валюты
    private String currencyCode;

    // Хранит номинал валюты и её кол-во
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        denominations = new TreeMap<>();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount() {
        int totalAmount = 0;
        for (Integer denomination : denominations.keySet()) {
            totalAmount += denomination * denominations.get(denomination);
        }
        return totalAmount;
    }

    public boolean hasMoney() {
        return !denominations.isEmpty();
    }
}