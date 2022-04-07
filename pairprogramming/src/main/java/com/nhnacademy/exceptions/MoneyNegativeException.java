package com.nhnacademy.exceptions;

public class MoneyNegativeException extends IllegalArgumentException{
    public MoneyNegativeException(String s) {
        super(s);
    }
}
