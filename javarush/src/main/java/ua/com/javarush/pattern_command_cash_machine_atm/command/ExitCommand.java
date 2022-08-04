package ua.com.javarush.pattern_command_cash_machine_atm.command;

import ua.com.javarush.pattern_command_cash_machine_atm.ConsoleHelper;
import ua.com.javarush.pattern_command_cash_machine_atm.exception.InterruptOperationException;

public class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Do you really want to exit: <y,n>");
        String result = ConsoleHelper.readString();
        if (result!= null && result.toLowerCase().equals("y")) {
            ConsoleHelper.writeMessage("Bye!");
        }
    }
}