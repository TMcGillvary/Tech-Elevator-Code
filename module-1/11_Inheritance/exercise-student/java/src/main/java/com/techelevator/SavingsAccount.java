package com.techelevator;

public class SavingsAccount extends BankAccount {

    //constructors
    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int accountBalance) {
        super(accountHolderName, accountNumber, accountBalance);
    }

    // Method Overrides
    @Override
    public int withdraw(int amountToWithdraw) {
        int serviceCharge = 2;
        int savingsAccountBalance;

        if ((getBalance() - amountToWithdraw - serviceCharge) < 0) {
            return getBalance();
        } else if ((getBalance() - amountToWithdraw) < 150) {
            savingsAccountBalance = super.withdraw(amountToWithdraw + serviceCharge);
        } else {
            savingsAccountBalance = super.withdraw(amountToWithdraw);
        }
        return savingsAccountBalance;
    }
}
