package com.codecool.frompythontojava.exercise3;


import java.util.Currency;

public class Main {
    public static void main(String[] args) throws Cancelled {
        User user = new User();
        Account userAccount = new Account(user, "11537808", Currency.getInstance("HUF"));

        // Trying to add dollars to a HUF-based account (will throw an error)
        Deposit deposit = new Deposit(200.0f, Currency.getInstance("USD"), userAccount);
        System.out.println(deposit.complete());

        // ... the right way
        Deposit depositAgain = new Deposit(200.0f, Currency.getInstance("HUF"), userAccount);
        System.out.println("The amount of the transaction: " + depositAgain.getAmount() + " " + depositAgain.getCurrency());
        System.out.println(depositAgain.complete());

        // Transfering some of it
        Account anotherAccount = new Account(new User(), "5317856", Currency.getInstance("HUF"));
        Transfer transfer = new Transfer(150f, Currency.getInstance("HUF"), anotherAccount, userAccount);
        System.out.println(transfer.complete());

        // (More than) The rest is taken away ... (will fail)
        try {
            Withdrawal withdrawal = new Withdrawal(60f, Currency.getInstance("HUF"), userAccount);
            System.out.println(withdrawal.complete());
        } catch (Cancelled ex) {
            ex.printStackTrace();
        }

        // Back to zero
        Withdrawal withdrawalAll = new Withdrawal(50f, Currency.getInstance("HUF"), userAccount);
        System.out.println(withdrawalAll.complete());
        System.out.println("Balance at the end: " + userAccount.getBalance() + " " + userAccount.getCurrency());
    }
}
