package com.company.cash;

/**
 * Created by Mantas on 2016-10-18.
 */
public class CashRegister {

    private double cash;

    protected void addCash(double cash) {
        this.cash += cash;
    }

    protected double takeCash(double cash) {
        this.cash -= cash;
        return this.cash;
    }

    public double getCash() {
        return cash;
    }
}
