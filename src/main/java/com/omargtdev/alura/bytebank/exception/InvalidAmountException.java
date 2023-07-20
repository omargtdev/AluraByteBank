package com.omargtdev.alura.bytebank.exception;

public class InvalidAmountException extends Exception {


    public InvalidAmountException(){
        super();
    }

    public InvalidAmountException(String message) {
        super(message);
    }

}
