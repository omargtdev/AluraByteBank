package com.omargtdev.alura.bytebank;

import com.omargtdev.alura.bytebank.entity.accounts.Account;
import com.omargtdev.alura.bytebank.entity.accounts.CheckingAccount;
import com.omargtdev.alura.bytebank.entity.accounts.SavingsAccount;
import com.omargtdev.alura.bytebank.exception.InsufficientFundsException;
import com.omargtdev.alura.bytebank.exception.InvalidAmountException;

public class AccountTest {

    public static void main(String[] args) {
        Account checkingAccount = new CheckingAccount(1234, Account.Agency.LIMA);
        Account savingsAccount = new SavingsAccount(1234, Account.Agency.AYACUCHO);

        try {
            checkingAccount.deposit(800);
            savingsAccount.deposit(230);
            checkingAccount.transferToAnother(
                    800, savingsAccount);
            checkingAccount.withdraw(200);
        } catch (InvalidAmountException | InsufficientFundsException ex) {
            System.out.println(ex.getClass().getName()
                    + ": " + ex.getMessage());
        } finally {
            System.out.println(checkingAccount.getBalance());
            System.out.println(savingsAccount.getBalance());
        }
    }

}
