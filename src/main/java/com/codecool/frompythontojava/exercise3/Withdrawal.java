package com.codecool.frompythontojava.exercise3;


import java.util.Currency;

public class Withdrawal extends Transaction {
    private Account from;

    public Withdrawal(float amount, Currency currency, Account from) {
        super(amount, currency);
        this.from = from;
    }

    @Override
    protected Receipt complete() throws Cancelled {
        Receipt receipt = new Receipt();

        try {
            if(super.getAmount() > from.getBalance()) {
                throw new Cancelled("The transaction cannot be completed. Not enough money in the source account");
            } else {
                this.from.decrease(super.getAmount(), super.getCurrency());
                receipt.addDetails(this.toString());
            }
        } catch (InvalidCurrency ex) {
            ex.printStackTrace();
        }
        return receipt;

    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "to= #withdrawal#" +
                ", from=" + from.getAccountNumber() +
                ", amount=" + super.getAmount() + super.getCurrency() +
                ", new balance=" + from.getBalance() +
                '}';
    }
}
