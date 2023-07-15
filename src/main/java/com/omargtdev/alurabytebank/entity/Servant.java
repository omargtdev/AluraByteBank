package com.omargtdev.alurabytebank.entity;

public class Servant {

    private String name;
    private String document;
    protected double salary;

    private Type type;

    public Servant() {}

    public Servant(String name, String document, double salary, Type type) {
        this.name = name;
        this.document = document;
        this.salary = salary;
        this.type = type;
    }

    public enum Type {
        TYPE_1,
        TYPE_2
    }

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getBonus(){
       return salary * .1;
    }
}
