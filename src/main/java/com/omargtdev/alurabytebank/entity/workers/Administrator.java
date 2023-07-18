package com.omargtdev.alurabytebank.entity.workers;

import com.omargtdev.alurabytebank.security.Authentication;
import com.omargtdev.alurabytebank.security.AuthenticationUtil;

import java.io.Serializable;

public class Administrator extends Worker implements Authentication {

    private AuthenticationUtil authenticationUtil =
            new AuthenticationUtil();


    @Override
    public double getBonus() {
        return 0;
    }

    @Override
    public void setPassword(String password) {
        authenticationUtil.setPassword(password);
    }

    @Override
    public boolean signIn(String password) {
        return authenticationUtil.signIn(password);
    }
}
