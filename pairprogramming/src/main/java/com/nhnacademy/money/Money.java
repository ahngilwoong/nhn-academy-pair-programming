package com.nhnacademy.money;

import com.nhnacademy.currency.Currency;
import com.nhnacademy.exceptions.MoneyNegativeException;
import java.util.Objects;

public class Money {
    private double balance;
    Currency currency;

    public static Money dollar(double balance){
        return new Money(balance, Currency.DOLLAR);
    }

    public static Money won(long balance){
        return new Money(balance, Currency.WON);
    }

    public double getBalance() {
        return balance;
    }

    public void setMoney(long balance) {
        this.balance = balance;
    }

    public Money(double balance, Currency currency) {
        if(balance < 0){
            throw new MoneyNegativeException("금액은 0원미만일 수 없습니다.");
        }
        this.balance = balance;
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Money money1 = (Money) o;

        return balance == money1.balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, currency);
    }
}
