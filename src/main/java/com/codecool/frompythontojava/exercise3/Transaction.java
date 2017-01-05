package com.codecool.frompythontojava.exercise3;


import java.util.Currency;
import java.util.UUID;

abstract class Transaction {
    private UUID id;
    private float amount;
    private Currency currency;

    public Transaction(float amount, Currency currency) {
        this.id = UUID.randomUUID();
        this.amount = amount;
        this.currency = currency;
    }

    protected abstract Receipt complete() throws Cancelled;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", currency=" + currency +
                '}';
    }
}
