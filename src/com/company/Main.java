package com.company;

import com.company.cash.CashRegister;
import com.company.cash.CommandHandler;
import com.company.cash.PutSomeCashIn;

public class Main {

    public static void main(String[] args) {

        CashRegister cashRegister = new CashRegister();

        CommandHandler commandHandler = new CommandHandler();

        commandHandler.enqueCommand(new PutSomeCashIn(cashRegister, 10));
        commandHandler.enqueCommand(new PutSomeCashIn(cashRegister, 12));

        commandHandler.rollback();

        commandHandler.enqueCommand(new PutSomeCashIn(cashRegister, 15));

        commandHandler.commit();

        commandHandler.executeCommand(new PutSomeCashIn(cashRegister, 19));

        commandHandler.undo();

        System.out.println(cashRegister.getCash());

        commandHandler.printLog();
    }
}
