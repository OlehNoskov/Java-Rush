package ua.com.javarush.multithreading.inner_classes.enums;

public class Solution {

    public static void main(String[] args) {

        Column.configureColumns(Column.Amount, Column.AccountNumber, Column.BankName);

        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }

        System.out.println("--------------------");
        Column.AccountNumber.hide();

        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }
    }
}
