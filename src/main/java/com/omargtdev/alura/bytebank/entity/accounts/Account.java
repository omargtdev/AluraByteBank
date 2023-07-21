package com.omargtdev.alura.bytebank.entity.accounts;

import com.omargtdev.alura.bytebank.entity.Client;
import com.omargtdev.alura.bytebank.exception.InsufficientFundsException;
import com.omargtdev.alura.bytebank.exception.InvalidAmountException;

/**
 * Main class to inherit for every new type account to
 * create like {@link CheckingAccount} or {@link SavingsAccount}.
 *
 * @author omargtdev
 * @version 1.0
 */
public abstract class Account {

    private int number;
    private Agency agency;
    private double balance;
    private Client client;

    /**
     * Create an account with its custom number and agency
     *
     * @param number The number of the account with which
     *               it'll be created.
     * @param agency The agency of the account.
     */
    public Account(int number, Agency agency) {
        this(number, agency, new Client());
    }

    public Account(int number, Agency agency, Client client) {
        this.balance = 0;
        this.agency = agency;
        this.number = number;
        this.client = client;
    }

    protected void checkInvalidAmount(double amount) throws InvalidAmountException {
        if (amount <= 0)
            throw new InvalidAmountException("The amount must be greater than 0.");
    }

    public void deposit(double amount) throws InvalidAmountException {
        this.checkInvalidAmount(amount);
        this.balance += amount;
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        this.checkInvalidAmount(amount);
        if (this.balance < amount)
            throw new InsufficientFundsException("The account balance is not enough to withdraw.");
        this.balance -= amount;
    }

    public void transferToAnother(double amount, Account destination) throws InvalidAmountException, InsufficientFundsException {
        if (!destination.equals(this)) {
            this.withdraw(amount);
            destination.deposit(amount);
        }
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
