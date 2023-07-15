package com.omargtdev.alurabytebank.entity;

import com.omargtdev.alurabytebank.security.Authentication;

public class Client implements Authentication {

    private String name;
    private String document;
    private String phoneNumber;
    private String password;

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
        this.password = password;
    }

    @Override
    public boolean signIn(String password) {
        return this.password.equals(password);
    }

}