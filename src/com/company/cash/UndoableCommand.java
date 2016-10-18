package com.company.cash;

/**
 * Created by Mantas on 2016-10-18.
 */
public interface UndoableCommand extends Command {

    void undo();

}
