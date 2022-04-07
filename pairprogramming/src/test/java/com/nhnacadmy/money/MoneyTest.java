package com.nhnacadmy.money;

import com.nhnacademy.currency.Currency;
import com.nhnacademy.exceptions.MoneyNegativeException;
import com.nhnacademy.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class MoneyTest {
    Currency currency;
    @Test
    @DisplayName("돈은 음수일 수 없다.")
    void if_money_negative_amount_throw_MoneyNegativeException(){
        assertThatThrownBy(() -> createMoney())
            .isInstanceOf(MoneyNegativeException.class)
            .hasMessageContaining("금액", "0원미만");
    }

    private Money createMoney(){
        return new Money(-2000,currency.WON);
    }
}
