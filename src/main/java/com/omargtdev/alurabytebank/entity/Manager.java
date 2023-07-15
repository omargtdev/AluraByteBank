package com.omargtdev.alurabytebank.entity;

public class Manager extends  Servant {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public double getBonus() {
        return super.getBonus() + super.getSalary();
    }

    public boolean signIn(String password){
        return this.password.equals(password);
    }

}
