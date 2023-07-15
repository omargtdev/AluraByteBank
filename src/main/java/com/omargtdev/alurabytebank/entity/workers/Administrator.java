package com.omargtdev.alurabytebank.entity.workers;

import com.omargtdev.alurabytebank.security.Authentication;

public class Administrator extends Worker implements Authentication {

    private String password;

    @Override
    public double getBonus() {
        return 0;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean signIn(String password) {
        return this.password.equals(password);
    }
}
