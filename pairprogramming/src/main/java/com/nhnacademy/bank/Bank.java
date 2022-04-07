package com.nhnacademy.bank;

import com.nhnacademy.currency.Currency;
import com.nhnacademy.money.Money;

public class Bank implements Calculatable {
    @Override
    public Money addMoney(Money money1, Money money2) {
        long resultMoney = money1.getBalance() + money2.getBalance();
        return new Money(resultMoney);
    }

    public boolean isEqualsMoney(Money money1, Money money2){
        return money1.equals(money2);
    }

}
