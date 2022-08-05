package ua.com.javarush.pattern_command_cash_machine_atm;

public enum Operation {
    LOGIN, INFO, DEPOSIT, WITHDRAW, EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) {
        if (i == LOGIN.ordinal()) {
            throw new IllegalArgumentException();
        }
        for (Operation operation : values()) {
            if (operation.ordinal() == i) {
                return operation;
            }
        }
        throw new IllegalArgumentException();
    }
}