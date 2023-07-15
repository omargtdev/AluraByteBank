package com.omargtdev.alurabytebank.security;

public interface Authentication {

    void setPassword(String password);

    boolean signIn(String password);

}
