package com.nhnacademy.bank;

import com.nhnacademy.money.Money;

public class Bank {
    public long addMoney(long money1, long money2) {
        return money1 + money2;
    }

    public boolean isEqualsMoney(Money money1, Money money2){
        return money1.equals(money2);
    }
}
