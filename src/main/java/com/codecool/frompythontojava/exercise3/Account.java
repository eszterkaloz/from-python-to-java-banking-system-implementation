package com.codecool.frompythontojava.exercise3;


import java.util.Currency;

public class Account {
    private User user;
    private String accountNumber;
    private Currency currency;
    private float balance;

    public Account(User user, String accountNumber, Currency currency) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.currency = currency;
    }

    public User getUser() {
        return user;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Currency getCurrency() {
        return currency;
    }

    public float getBalance() {
        return balance;
    }

    public boolean increase(float amount, Currency currency) throws InvalidCurrency {
        if (this.currency.equals(currency)) {
            this.balance += amount;
            return true;
        } else {
            throw new InvalidCurrency("The supplied currency code is invalid");
        }
    }

    public boolean decrease(float amount, Currency currency) throws InvalidCurrency {
        if (this.currency.equals(currency)) {
            this.balance -= amount;
            return true;
        } else {
            throw new InvalidCurrency("The supplied currency code is invalid");
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "user=" + user +
                ", accountNumber='" + accountNumber + '\'' +
                ", currency=" + currency +
                ", balance=" + balance +
                '}';
    }
}
