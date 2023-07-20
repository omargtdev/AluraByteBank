package com.omargtdev.alura.bytebank.entity.accounts;

import com.omargtdev.alura.bytebank.entity.Client;

public class SavingsAccount extends Account {

    public SavingsAccount(int number, Agency agency) {
        super(number, agency);
    }

    public SavingsAccount(int number, Agency agency, Client client) {
        super(number, agency, client);
    }
}
