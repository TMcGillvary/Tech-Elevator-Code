package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {

    // instance variables
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts;

    // constructors

    public BankCustomer() {
       this.accounts = new ArrayList<Accountable>();
    }

    // getters & setters

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // put getter for Account list here

    public Accountable[] getAccounts() {
        Accountable[] accountsArray = accounts.toArray(new Accountable[0]);
        return accountsArray;
    }

    // helper Methods

    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }

    public boolean isVip() {
        int sum = 0;
        for (Accountable account : accounts) {
            sum += account.getBalance();
        }
        return sum >= 25000;
    }
}
