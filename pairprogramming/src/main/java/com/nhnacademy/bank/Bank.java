package com.nhnacademy.bank;

import com.nhnacademy.exceptions.MoneyNegativeException;
import com.nhnacademy.money.Money;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Bank implements Calculatable {
    @Override
    public Money addMoney(Money money1, Money money2) {
        String resultStrMoney = (money1.getBalance() + money2.getBalance())+"";
        BigDecimal bigDecimal = new BigDecimal(resultStrMoney).setScale(2, RoundingMode.FLOOR);
        double resultMoney = bigDecimal.doubleValue();
        return new Money(resultMoney, money1.getCurrency());
    }

    @Override
    public Money subtractMoney(Money money1, Money money2) {
        double resultMoney = money1.getBalance() - money2.getBalance();
        if(resultMoney < 0) {
            throw new MoneyNegativeException("잔액이 부족합니다.");
        }
        return new Money(resultMoney, money1.getCurrency());
    }

    public boolean isEqualsMoney(Money money1, Money money2){
        return money1.equals(money2);
    }

    public Money dollarToWon(Money dollar) {
        double changedWon = (dollar.getBalance() * 100);
        return Money.won(Math.round(changedWon) * 10);
    }

    public Money wonToDollar(Money won){
        double changedDollar = (won.getBalance() * 0.1);
        double roundedBalance = Math.round(changedDollar) * 0.01;
        NumberFormat formatter = new DecimalFormat("#0.00");
        return Money.dollar(new Double(formatter.format(roundedBalance)));

    }

    public Money euroToWon(Money euro) {
        double changedWon = (euro.getBalance() * 100);
        return Money.won(Math.round(changedWon) * 12);
    }

    public Money euroTodollar(Money euro) {
        double changedDollar = (euro.getBalance() * 1.2);
        return Money.dollar(Math.round(changedDollar * 100) * 0.01);
    }
}
