package com.omargtdev.alurabytebank.entity.accounts;

import com.omargtdev.alurabytebank.entity.Client;

public class CheckingAccount extends Account {

    private final static double MOVEMENT_FEE = 0.20;

    public CheckingAccount(int number, Agency agency) {
        super(number, agency);
    }

    public CheckingAccount(int number, Agency agency, Client client) {
        super(number, agency, client);
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount + MOVEMENT_FEE);
    }
}
