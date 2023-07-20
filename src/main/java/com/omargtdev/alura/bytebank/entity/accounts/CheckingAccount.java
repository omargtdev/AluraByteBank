package com.omargtdev.alura.bytebank.entity.accounts;

import com.omargtdev.alura.bytebank.entity.Client;
import com.omargtdev.alura.bytebank.exception.InsufficientFundsException;
import com.omargtdev.alura.bytebank.exception.InvalidAmountException;

public class CheckingAccount extends Account {

    private final static double MOVEMENT_FEE = 0.20;

    public CheckingAccount(int number, Agency agency) {
        super(number, agency);
    }

    public CheckingAccount(int number, Agency agency, Client client) {
        super(number, agency, client);
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        super.withdraw(amount + MOVEMENT_FEE);
    }
}
