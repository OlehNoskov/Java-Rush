package ua.com.javarush.pattern_command_cash_machine_atm.command;

import ua.com.javarush.pattern_command_cash_machine_atm.ConsoleHelper;
import ua.com.javarush.pattern_command_cash_machine_atm.CurrencyManipulator;
import ua.com.javarush.pattern_command_cash_machine_atm.CurrencyManipulatorFactory;
import ua.com.javarush.pattern_command_cash_machine_atm.exception.InterruptOperationException;

public class DepositCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Depositing...");
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        while (true) {
            String[] split = ConsoleHelper.getValidTwoDigits(currencyCode);
            try {
                int denomination = Integer.parseInt(split[0]);
                int count = Integer.parseInt(split[1]);
                manipulator.addAmount(denomination, count);
                ConsoleHelper.writeMessage(String.format("%d %s was deposited successfully", (denomination * count), currencyCode));
                break;
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage("Please specify valid data.");
            }
        }
    }
}