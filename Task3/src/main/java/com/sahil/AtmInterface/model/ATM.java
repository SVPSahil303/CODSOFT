package com.sahil.AtmInterface.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ATM {

    private BankAccount account;

    @Autowired
    public ATM(BankAccount account) {
        this.account = account;
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public String withdraw(double amount) {
        return account.withdraw(amount);
    }

    public double checkBalance() {
        return account.checkBalance();
    }
}
