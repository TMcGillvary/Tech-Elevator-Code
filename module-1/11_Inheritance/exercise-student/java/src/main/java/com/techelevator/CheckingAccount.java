package com.techelevator;

public class CheckingAccount extends BankAccount {

    // constructor
    public CheckingAccount(String accountHolderName, String accountNumber, int accountBalance) {
        super(accountHolderName, accountNumber, accountBalance);
    }

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    // Method Overrides
    @Override
    public int withdraw(int amountToWithdraw) {
        int charge = 10;
        int checkingAccountBalance;

        if (getBalance() - amountToWithdraw < 0) {
            if ((getBalance() - amountToWithdraw) <= -100) {
                return getBalance();
            } else {
                checkingAccountBalance = super.withdraw(amountToWithdraw + charge);
            }
        } else {
            checkingAccountBalance = super.withdraw(amountToWithdraw);
        }
        return checkingAccountBalance;
    }
}
