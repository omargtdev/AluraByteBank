package com.omargtdev.alura.bytebank.security;

public interface Authentication {

    void setPassword(String password);

    boolean signIn(String password);

}
