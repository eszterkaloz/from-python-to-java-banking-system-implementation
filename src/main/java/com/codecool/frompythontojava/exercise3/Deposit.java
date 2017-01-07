package com.codecool.frompythontojava.exercise3;


import java.util.Currency;

public class Deposit extends Transaction {
    private Account to;

    public Deposit(float amount, Currency currency, Account to) {
        super(amount, currency);
        this.to = to;
    }

    @Override
    protected Receipt complete() throws Cancelled {
        Receipt receipt = new Receipt();

        try {
            if(this.to.increase(super.getAmount(), super.getCurrency())) {
                receipt.addDetails(this.toString());
            } else throw new Cancelled("Invalid currency code. Transaction cancelled.");
        } catch (InvalidCurrency ex) {
            ex.printStackTrace();
        }

        return receipt;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "to=" + to.getAccountNumber() +
                ", from= #deposit#" +
                ", amount=" + super.getAmount() + super.getCurrency() +
                ", new balance=" + to.getBalance() +
                '}';
    }
}
