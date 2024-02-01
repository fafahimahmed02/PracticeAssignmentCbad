package com.wsd.banking_application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

       /* int exit = -1;

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        while (true) {
            // Enter data using BufferReader

            // Reading data using readLine
            String input = reader.readLine();

            Operation operation = Operation.INVALID;

            try {
                operation = Operation.valueOf(input);
            } catch (IllegalArgumentException e) {
            }

            // Printing the read line
            System.out.println(operation);

            System.out.println("Hello world!");

            if(operation == Operation.Exit) break;
        }*/

        AccountManagement accountManagement = new AccountManagement();

        accountManagement.create("Feroj", 1000, AccountType.CURRENT);
        accountManagement.create("Rifat", 500, AccountType.SAVINGS);

        accountManagement.printAllAccount();

        accountManagement.withdraw("101", 100);
        accountManagement.printAllAccount();

        accountManagement.withdraw("102", 100);
        accountManagement.printAllAccount();

        accountManagement.deposit("102", 100);
        accountManagement.printAllAccount();

        accountManagement.updateAccount("101", "Feroj Ahmed");
        accountManagement.printAllAccount();

        accountManagement.delete("102");
        accountManagement.printAllAccount();

        accountManagement.search("102");
        accountManagement.search("101");
    }
}