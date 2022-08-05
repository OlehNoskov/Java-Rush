package ua.com.javarush.pattern_command_cash_machine_atm;

import ua.com.javarush.pattern_command_cash_machine_atm.command.CommandExecutor;
import ua.com.javarush.pattern_command_cash_machine_atm.exception.InterruptOperationException;

import java.util.*;

public class CashMachine {

    public static void main(String[] args) {
        try {
        Locale.setDefault(Locale.ENGLISH);
        Operation operation;
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        } catch (InterruptOperationException e) {
            ConsoleHelper.writeMessage("Bye!");
        }
    }
}