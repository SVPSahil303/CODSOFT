package com.sahil.AtmInterface.model;

import org.springframework.stereotype.Component;

@Component
public class BankAccount {

    private double balance;

    public BankAccount() {
        // Default constructor
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public String withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return "Successful";
        } else {
            return "Failed ! Insufficient Balance..";
        }
    }

    public double checkBalance() {
        return balance;
    }
}
