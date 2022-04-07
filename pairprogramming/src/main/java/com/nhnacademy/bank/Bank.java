package com.nhnacademy.bank;

import com.nhnacademy.money.Money;

public class Bank {
    public Money addMoney(Money money1, Money money2) {
        long resultMoney = money1.getMoney() + money2.getMoney();
        return new Money(resultMoney);
    }

    public boolean isEqualsMoney(Money money1, Money money2){
        return money1.equals(money2);
    }
}
