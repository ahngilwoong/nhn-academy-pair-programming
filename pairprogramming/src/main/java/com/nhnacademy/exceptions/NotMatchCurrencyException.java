package com.nhnacademy.exceptions;

public class NotMatchCurrencyException extends IllegalArgumentException{
    public NotMatchCurrencyException(String s) {
        super(s);
    }
}
