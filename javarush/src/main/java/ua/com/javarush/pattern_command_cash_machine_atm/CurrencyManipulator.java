package ua.com.javarush.pattern_command_cash_machine_atm;

import ua.com.javarush.pattern_command_cash_machine_atm.exception.NotEnoughMoneyException;

import java.util.*;

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

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        int sum = expectedAmount;
        HashMap<Integer, Integer> copyDenominations = new HashMap<>(denominations);

        ArrayList<Integer> keys = new ArrayList<>(this.denominations.keySet());

        Collections.sort(keys);
        Collections.reverse(keys);

        TreeMap<Integer, Integer> resultMap = new TreeMap<>(Comparator.reverseOrder());

        for (Integer denomination : keys) {
            final int key = denomination;
            int value = copyDenominations.get(key);
            while (true) {
                if (sum < key || value == 0) {
                    copyDenominations.put(key, value);
                    break;
                }
                sum -= key;
                value--;

                if (resultMap.containsKey(key))
                    resultMap.put(key, resultMap.get(key) + 1);
                else
                    resultMap.put(key, 1);
            }
        }
        if (sum > 0)
            throw new NotEnoughMoneyException();
        else {
            this.denominations.clear();
            this.denominations.putAll(copyDenominations);
        }
        return resultMap;
    }
}