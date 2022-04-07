package com.nhnacademy.money;

import com.nhnacademy.currency.Currency;
import com.nhnacademy.exceptions.MoneyNegativeException;

public class Money {
    private long balance;
    Currency currency;

    public long getBalance() {
        return balance;
    }

    public void setMoney(long balance) {
        this.balance = balance;
    }

    public Money(long balance, Currency currency) {
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
        return (int) (balance ^ (balance >>> 32));
    }
}
