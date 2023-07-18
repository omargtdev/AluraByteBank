package com.omargtdev.alurabytebank;

import com.omargtdev.alurabytebank.entity.Client;
import com.omargtdev.alurabytebank.entity.accounts.Account;
import com.omargtdev.alurabytebank.entity.accounts.CheckingAccount;
import com.omargtdev.alurabytebank.entity.accounts.SavingsAccount;
import com.omargtdev.alurabytebank.entity.workers.*;
import com.omargtdev.alurabytebank.exception.InsufficientFundsException;
import com.omargtdev.alurabytebank.exception.InvalidAmountException;
import com.omargtdev.alurabytebank.helper.BonusControl;
import com.omargtdev.alurabytebank.security.Authentication;
import com.omargtdev.alurabytebank.security.InternalSystem;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //employees();

        accounts();

        //login();
    }

    public static void employees(){
        // Employees
        Worker manager = new Manager();
        manager.setSalary(6000.50);

        Worker videoEditor = new VideoEditor();
        videoEditor.setSalary(3500.50);

        Worker designer = new Designer();
        videoEditor.setSalary(2800);

        BonusControl bonusControl = new BonusControl();
        bonusControl.registerBonus(manager, videoEditor, designer);

        System.out.println(bonusControl.getAmount());
    }

    public static void accounts(){
        Account checkingAccount = new CheckingAccount(1234, Account.Agency.LIMA);
        Account savingsAccount = new SavingsAccount(1234, Account.Agency.AYACUCHO);

        try {
            checkingAccount.deposit(800);
            savingsAccount.deposit(230);
            checkingAccount.transferToAnother(
                    800, savingsAccount);
            checkingAccount.withdraw(200);
        } catch (InvalidAmountException | InsufficientFundsException ex){
            System.out.println(ex.getClass().getName()
                    + ": " + ex.getMessage());
        } finally {
            System.out.println(checkingAccount.getBalance());
            System.out.println(savingsAccount.getBalance());
        }
    }

    public static void login(){
        Authentication client = new Client();
        client.setPassword("mySecretPassword");

        Authentication admin = new Administrator();
        admin.setPassword("holi123");

        Authentication manager = new Manager();
        manager.setPassword("pass123");

        InternalSystem internalSystem = new InternalSystem();

        internalSystem.authenticate(client);
        internalSystem.authenticate(admin);
        internalSystem.authenticate(manager);
    }

}