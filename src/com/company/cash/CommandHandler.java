package com.company.cash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mantas on 2016-10-18.
 */
public class CommandHandler {

    private List<Command> executedCommands = new ArrayList<>();

    private List<Command> commandQueue = new ArrayList<>();

    public void executeCommand(Command command) {
        command.execute();
        executedCommands.add(command);
    }

    public void enqueCommand(Command command) {
        commandQueue.add(command);
    }

    public void commit() {
        commandQueue.forEach(
                command -> executeCommand(command)
        );

        commandQueue.clear();
    }

    public void rollback() {
        commandQueue.clear();
    }

    public void undo() {
        Command lastExecutedCommand = executedCommands.get(lastCommandIndex());

        if (lastExecutedCommand instanceof UndoableCommand) {
            ((UndoableCommand) lastExecutedCommand).undo();
            executedCommands.remove(lastCommandIndex());
        }
    }

    private int lastCommandIndex() {
        return executedCommands.size() - 1;
    }

    public void printLog() {
        executedCommands.forEach(
                command -> System.out.println(command)
        );
    }


}
