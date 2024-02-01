package com.wsd.banking_application;

import java.util.ArrayList;
import java.util.List;

public class AccountManagement {

    private final List<Account> accountList;

    public AccountManagement() {
        accountList = new ArrayList<>();
    }

    public void printAllAccount() {
        int i = 0;
        for (Account account : accountList) {
            account.printDetails();
            i++;

            if(i != accountList.size()) System.out.println("\n");
        }
    }

    public void updateAccount(String accountNumber, String name) {
        for(Account account : accountList) {
            if(account.getNumber().equalsIgnoreCase(accountNumber)) {
                account.update(name);
            }
        }
    }

    public void deposit(String accountNumber, int balance) {
        for(Account account : accountList) {
            if(account.getNumber().equalsIgnoreCase(accountNumber)) {
                account.deposit(balance);
            }
        }
    }

    public void withdraw(String accountNumber, int balance) {
        for(Account account : accountList) {
            if(account.getNumber().equalsIgnoreCase(accountNumber)) {
                try {
                    account.withdraw(balance);
                    System.out.println("Succesfully withdrawn");
                } catch (IllegalArgumentException e) {
                    System.out.println("Can not withdraw");
                }
            }
        }
    }

    public void delete(String accountNumber) {
        Account desiredAccount = null;

        for(Account account : accountList) {
            if(account.getNumber().equalsIgnoreCase(accountNumber)) {
                desiredAccount = account;
                break;
            }
        }

        if(desiredAccount != null) accountList.remove(desiredAccount);
    }

    public void create(String name, int balance, AccountType accountType) {
        Account account = new Account(name, balance, accountType);
        accountList.add(account);
    }

    public void search(String accountNumber) {
        Account desiredAccount = null;

        for(Account account : accountList) {
            if(account.getNumber().equalsIgnoreCase(accountNumber)) {
                desiredAccount = account;
                break;
            }
        }

        if(desiredAccount == null) System.out.println("COuld not found account");
        else {
            desiredAccount.printDetails();
        }
    }
}
