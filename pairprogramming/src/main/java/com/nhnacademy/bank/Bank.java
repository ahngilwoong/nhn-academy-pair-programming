package com.nhnacademy.bank;

import com.nhnacademy.exceptions.MoneyNegativeException;
import com.nhnacademy.money.Money;

public class Bank implements Calculatable {
    @Override
    public Money addMoney(Money money1, Money money2) {
        long resultMoney = money1.getBalance() + money2.getBalance();
        return new Money(resultMoney, money1.getCurrency());
    }

    @Override
    public Money subtractMoney(Money money1, Money money2) {
        long resultMoney = money1.getBalance() - money2.getBalance();
        if(resultMoney < 0) {
            throw new MoneyNegativeException("잔액이 부족합니다.");
        }
        return new Money(resultMoney, money1.getCurrency());
    }

    public boolean isEqualsMoney(Money money1, Money money2){
        return money1.equals(money2);
    }

}
