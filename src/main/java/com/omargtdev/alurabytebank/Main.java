package com.omargtdev.alurabytebank;

import com.omargtdev.alurabytebank.entity.Designer;
import com.omargtdev.alurabytebank.entity.Manager;
import com.omargtdev.alurabytebank.entity.Servant;
import com.omargtdev.alurabytebank.entity.VideoEditor;
import com.omargtdev.alurabytebank.entity.accounts.Account;
import com.omargtdev.alurabytebank.entity.accounts.CheckingAccount;
import com.omargtdev.alurabytebank.entity.accounts.SavingsAccount;
import com.omargtdev.alurabytebank.helper.BonusControl;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //employees();

        accounts();
    }

    public static void employees(){
        // Employees
        Servant manager = new Manager();
        manager.setSalary(6000.50);

        Servant videoEditor = new VideoEditor();
        videoEditor.setSalary(3500.50);

        Servant designer = new Designer();
        videoEditor.setSalary(2800);

        BonusControl bonusControl = new BonusControl();
        bonusControl.registerBonus(manager, videoEditor, designer);

        System.out.println(bonusControl.getAmount());
    }

    public static void accounts(){
        Account checkingAccount = new CheckingAccount(1234, Account.Agency.LIMA);
        Account savingsAccount = new SavingsAccount(1234, Account.Agency.AYACUCHO);

        System.out.println(checkingAccount.deposit(800));
        System.out.println(savingsAccount.deposit(1000));

        System.out.println("Transfer: " + checkingAccount.transferToAnother(
                799.80, savingsAccount));

        System.out.println(checkingAccount.getBalance());
        System.out.println(savingsAccount.getBalance());
    }

}