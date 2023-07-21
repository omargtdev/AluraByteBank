package com.omargtdev.alura.bytebank.entity;

import com.omargtdev.alura.bytebank.security.Authentication;
import com.omargtdev.alura.bytebank.security.AuthenticationUtil;

public class Client implements Authentication {

    private String name;
    private String document;
    private String phoneNumber;

    private AuthenticationUtil authenticationUtil =
            new AuthenticationUtil();

    public Client() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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