package com.omargtdev.alurabytebank.entity.accounts;

import com.omargtdev.alurabytebank.entity.Client;

public class SavingsAccount extends Account {

    public SavingsAccount(int number, Agency agency) {
        super(number, agency);
    }

    public SavingsAccount(int number, Agency agency, Client client) {
        super(number, agency, client);
    }
}
