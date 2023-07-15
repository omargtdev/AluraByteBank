package com.omargtdev.alurabytebank.entity.workers;

public class Manager extends Worker {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public double getBonus() {
        return super.getSalary();
    }

    public boolean signIn(String password){
        return this.password.equals(password);
    }

}
