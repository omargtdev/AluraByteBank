package com.omargtdev.alurabytebank.entity.accounts;

import com.omargtdev.alurabytebank.entity.Client;

public abstract class Account {

    private int number;
    private Agency agency;
    private double balance;
    private Client client;

    public Account(int number, Agency agency) {
        this(number, agency, new Client());
    }

    public Account(int number, Agency agency, Client client) {
        this.balance = 0;
        this.agency = agency;
        this.number = number;
        this.client = client;
    }

    public boolean deposit(double amount){
        if(isInvalidAmount(amount))
            return false;

        this.balance += amount;
        return true;
    }

    protected boolean isInvalidAmount(double amount){
        return amount <= 0;
    }

    protected boolean cannotBeWithdrawn(double amountToWithdrawn){
        return isInvalidAmount(amountToWithdrawn) ||
                (this.balance <= 0 || this.balance < amountToWithdrawn);
    }

    public boolean withdraw(double amount){
        if(cannotBeWithdrawn(amount))
            return false;
        this.balance -= amount;
        return true;
    }

    public boolean transferToAnother(double amount, Account destination){
        if(destination.equals(this))
            return false;

        boolean wasSatisfactoryWithdraw = withdraw(amount);
        if(!wasSatisfactoryWithdraw)
            return false;

        boolean wasSatisfactoryDeposit = destination.deposit(amount);
        return wasSatisfactoryDeposit;
    }

    public enum Agency {
        LIMA,
        AYACUCHO
        //....
    }

    public double getBalance() {
        return balance;
    }

    public Agency getAgency() {
        return agency;
    }

    public int getNumber() {
        return number;
    }

    public Client getClient() {
        return client;
    }

}
