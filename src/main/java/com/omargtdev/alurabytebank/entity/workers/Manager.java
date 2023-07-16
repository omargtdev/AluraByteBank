package com.omargtdev.alurabytebank.entity.workers;

import com.omargtdev.alurabytebank.security.Authentication;
import com.omargtdev.alurabytebank.security.AuthenticationUtil;

public class Manager extends Worker implements Authentication {

    private AuthenticationUtil authenticationUtil =
            new AuthenticationUtil();

    @Override
    public double getBonus() {
        return super.getSalary();
    }

    @Override
    public void setPassword(String password) {
        authenticationUtil.setPassword(password);
    }

    @Override
    public boolean signIn(String password){
        return authenticationUtil.signIn(password);
    }

}
