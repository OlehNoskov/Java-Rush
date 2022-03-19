package ua.com.javarush.archiver;

import ua.com.javarush.archiver.command.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<Operation, Command> ALL_KNOW_COMMANDS_MAP = new HashMap<>();

    //Запрет явного вызова конструктора класса
    private CommandExecutor() {
    }

    //Статический блок инициализации так как хранилище создается один раз!
    static {
        ALL_KNOW_COMMANDS_MAP.put(Operation.CREATE,new ZipCreateCommand());
        ALL_KNOW_COMMANDS_MAP.put(Operation.ADD,new ZipAddCommand());
        ALL_KNOW_COMMANDS_MAP.put(Operation.REMOVE,new ZipRemoveCommand());
        ALL_KNOW_COMMANDS_MAP.put(Operation.EXTRACT,new ZipExtractCommand());
        ALL_KNOW_COMMANDS_MAP.put(Operation.CONTENT,new ZipExtractCommand());
        ALL_KNOW_COMMANDS_MAP.put(Operation.EXIT,new ExitCommand());
    }

    public static void execute(Operation operation) throws IOException {
       ALL_KNOW_COMMANDS_MAP.get(operation).execute();
    }
}