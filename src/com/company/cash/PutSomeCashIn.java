package com.company.cash;

/**
 * Created by Mantas on 2016-10-18.
 */
public class PutSomeCashIn implements UndoableCommand {

    private CashRegister cashRegister;

    private double cashAmount;

    public PutSomeCashIn(CashRegister cashRegister, double cashAmount) {
        this.cashRegister = cashRegister;
        this.cashAmount = cashAmount;
    }

    @Override
    public void execute() {
        this.cashRegister.addCash(cashAmount);
    }

    @Override
    public void undo() {
        this.cashRegister.takeCash(cashAmount);
    }

    @Override
    public String toString() {
        return "PutSomeCashIn{" +
                "cashRegister=" + cashRegister +
                ", cashAmount=" + cashAmount +
                '}';
    }


}
