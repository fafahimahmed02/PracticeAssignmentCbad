package com.wsd.banking_application;

import java.util.Date;
import java.util.UUID;

public class Account {

    public static final int MIN_BALANCE = 500;
    public static int u_number = 100;

    private String name;
    private String number;
    private Date creationDate;
    private int balance;

    private AccountType accountType;

    public Account(String name,int deposit, AccountType accountType){
        this.name = name;
        this.balance = deposit;
        this.accountType = accountType;
        creationDate = new Date();
        //number = UUID.randomUUID().toString();
        u_number++;
        number = String.valueOf(u_number);

    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void update(String name) {
        this.name = name;
    }

    public void deposit(int balance) {
        this.balance += balance;
    }

    public void withdraw(int balance) {
        int tempBalance = this.balance - balance;

        if(tempBalance < MIN_BALANCE) {
            throw new IllegalArgumentException("");
        }

        this.balance -= balance;
    }

    public void printDetails() {
        System.out.println(String.format("Name: %s\nAccount number: %s\n" +
                "Current Balance: %d\nAccount Type: %s\n" +
                "Creation Date: %s", name, number, balance, accountType.name(), creationDate.toString()));
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Account) {
            return ((Account) obj).getNumber().equalsIgnoreCase(this.number);
        }
        return super.equals(obj);
    }
}
