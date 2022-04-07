package com.nhnacadmy.bank;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.bank.Bank;
import com.nhnacademy.currency.Currency;
import com.nhnacademy.money.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankTest  {
    Bank bank;
    Currency currency;

    @BeforeEach
    void setUp(){
        bank = new Bank();
    }

    @Test
    @DisplayName("금액을 더하는 기능 구현.")
    void add_money(){
        Money money1 = new Money(1000,);
        Money money2 = new Money(1000,);
        assertThat(bank.addMoney(money1, money2).getBalance()).isEqualTo(2000);
    }

    @Test
    @DisplayName("돈의 실제값이 같은지 확인.")
    void eqauls_money(){
        Money money1 = new Money(2000L);
        Money money2 = new Money(2000L);
        assertThat(bank.isEqualsMoney(money1, money2)).isTrue();
    }

    @Test
    @DisplayName("5$ + 5$ = 10$")
    void add_dollar_money() {
        Money money1 = new Money(5);
        Money money2 = new Money(5);
        assertThat(bank.addMoney(money1, money2)).isEqualTo(10);
    }

    private static Currency won_currency_constructor(Currency currency){
        currency = Currency.WON;
        return currency;
    }

    private static Currency dollar_currency_constructor(Currency currency){
        currency = Currency.WON;
        return currency;
    }

}
