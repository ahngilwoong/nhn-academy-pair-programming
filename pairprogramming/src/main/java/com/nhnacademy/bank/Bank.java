package com.nhnacademy.bank;

import com.nhnacademy.currency.Currency;
import com.nhnacademy.exceptions.MoneyNegativeException;
import com.nhnacademy.exceptions.NotMatchCurrencyException;
import com.nhnacademy.money.Money;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

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
        checkEqualCurrency(Currency.DOLLAR, dollar.getCurrency());
        double changedWon = (dollar.getBalance() * 100);
        return Money.won(Math.round(changedWon) * 10);
    }

    public Money wonToDollar(Money won){
        checkEqualCurrency(Currency.WON, won.getCurrency());
        double changedDollar = (won.getBalance() * 0.1);
        double roundedBalance = Math.round(changedDollar) * 0.01;
        NumberFormat formatter = new DecimalFormat("#0.00");
        return Money.dollar(Double.parseDouble(formatter.format(roundedBalance)));

    }

    public Money euroToWon(Money euro) {
        checkEqualCurrency(Currency.EURO, euro.getCurrency());
        double changedWon = (euro.getBalance() * 100);
        return Money.won(Math.round(changedWon) * 12);
    }

    public Money euroToDollar(Money euro) {
        checkEqualCurrency(Currency.EURO, euro.getCurrency());
        double changedDollar = (euro.getBalance() * 1.2);
        return Money.dollar(Math.round(changedDollar * 100) * 0.01);
    }

    public Money dollarToEuro(Money dollar) {
        checkEqualCurrency(Currency.DOLLAR, dollar.getCurrency());
        double changedEuro = (dollar.getBalance() / 1.2);
        return Money.euro(Math.round(changedEuro * 100) * 0.01);
    }

    public Money wonToEuro(Money won) {
        checkEqualCurrency(Currency.WON, won.getCurrency());
        double changedWon = (won.getBalance() / 100); // == 1.2
        return Money.euro(Math.round(changedWon) / 12);
    }

    private void checkEqualCurrency(Currency standard , Currency expectedResult){
        if(!Objects.equals(standard, expectedResult)){
            throw new NotMatchCurrencyException("화폐단위가 올바르지않습니다.");
        }
    }

}
