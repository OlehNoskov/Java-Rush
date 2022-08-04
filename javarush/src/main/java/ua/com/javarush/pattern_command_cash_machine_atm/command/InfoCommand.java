package ua.com.javarush.pattern_command_cash_machine_atm.command;


import ua.com.javarush.pattern_command_cash_machine_atm.ConsoleHelper;
import ua.com.javarush.pattern_command_cash_machine_atm.CurrencyManipulator;
import ua.com.javarush.pattern_command_cash_machine_atm.CurrencyManipulatorFactory;

public class InfoCommand implements Command {
    @Override
    public void execute() {
        ConsoleHelper.writeMessage("Information:");
        if (CurrencyManipulatorFactory.getAllCurrencyManipulators().isEmpty()) {
            ConsoleHelper.writeMessage("No money available :(" + "\n");
        }
        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
            if (manipulator.hasMoney()) {
                ConsoleHelper.writeMessage("\t" + manipulator.getCurrencyCode() + "-" + manipulator.getTotalAmount());
            }
        }
    }
}