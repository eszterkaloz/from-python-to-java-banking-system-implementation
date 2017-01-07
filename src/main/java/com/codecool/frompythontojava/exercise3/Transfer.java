package com.codecool.frompythontojava.exercise3;


import java.util.Currency;

public class Transfer extends Transaction {
    private Account to;
    private Account from;

    public Transfer(float amount, Currency currency, Account to, Account from) {
        super(amount, currency);
        this.to = to;
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
                this.to.increase(super.getAmount(), super.getCurrency());
                receipt.addDetails(this.toString());
            }
        } catch (InvalidCurrency ex) {
            ex.printStackTrace();
        }
        return receipt;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "to=" + to.getAccountNumber() +
                ", from=" + from.getAccountNumber() +
                ", amount=" + super.getAmount() + super.getCurrency() +
                ", new balance of the sender=" + from.getBalance() +
                ", new balance of the receiver=" + to.getBalance() +
                '}';
    }


}
