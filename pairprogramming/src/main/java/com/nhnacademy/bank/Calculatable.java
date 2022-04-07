package com.nhnacademy.bank;

import com.nhnacademy.currency.Currency;
import com.nhnacademy.money.Money;

public interface Calculatable {
    Money addMoney(Money money1, Money money2);
    Money subtractMoney(Money money1, Money moeny2);
}
