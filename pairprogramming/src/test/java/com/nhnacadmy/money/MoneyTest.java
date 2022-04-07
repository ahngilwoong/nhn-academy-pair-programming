package com.nhnacadmy.money;

import com.nhnacademy.currency.Currency;
import com.nhnacademy.exceptions.AnotherCurrencyException;
import com.nhnacademy.exceptions.MoneyNegativeException;
import com.nhnacademy.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class MoneyTest {
    @Test
    @DisplayName("돈은 음수일 수 없다.")
    void if_money_negative_amount_throw_MoneyNegativeException(){
        assertThatThrownBy(() ->Money.dollar(-1))
            .isInstanceOf(MoneyNegativeException.class)
            .hasMessageContaining("금액", "0원미만");
    }

    @Test
    @DisplayName("통화는 달러화와 원화만이 존재하고 다른 통화가 들어오면 예외를 던짐")
    void another_currency_input_then_throw_AnotherCurrencyException(){
        assertThatThrownBy(this::another_money_constructor)
            .isInstanceOf(AnotherCurrencyException.class)
            .hasMessageContaining("달러","원화");
    }

    private Money another_money_constructor(){
        Money money1;
        money1 = new Money(10000,Currency.YEN);
        return money1;
    }

    @Test
    @DisplayName("유로화 money 생성")
    void create_euro_money(){
        Money money;
        money = new Money(20000,Currency.EURO);
        assertThat(money.getCurrency()).isEqualTo(Currency.EURO);
    }

}
