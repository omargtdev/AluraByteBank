package com.omargtdev.alura.bytebank.security;

public class AuthenticationUtil implements Authentication {

    private String password;

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean signIn(String password) {
        return this.password.equals(password);
    }
}
