package com.omargtdev.alura.bytebank.entity.workers;

import com.omargtdev.alura.bytebank.security.Authentication;
import com.omargtdev.alura.bytebank.security.AuthenticationUtil;

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
