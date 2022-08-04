package ua.com.javarush.pattern_command_cash_machine_atm.command;

import ua.com.javarush.pattern_command_cash_machine_atm.exception.InterruptOperationException;

public interface Command {
    void execute() throws InterruptOperationException;
}