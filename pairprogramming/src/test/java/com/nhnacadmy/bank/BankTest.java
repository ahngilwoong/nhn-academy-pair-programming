package com.nhnacadmy.bank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
        Money money1 = Money.won(1000);
        Money money2 = Money.won(1000);
        assertThat(bank.addMoney(money1, money2).getBalance()).isEqualTo(2000);
    }

    @Test
    @DisplayName("돈의 실제값이 같은지 확인.")
    void eqauls_money(){
        Money money1 = Money.won(2000);
        Money money2 = Money.won(2000);
        assertThat(bank.isEqualsMoney(money1, money2)).isTrue();
    }

    @Test
    @DisplayName("5$ + 5$ = 10$")
    void add_dollar_money() {
        Money money2 = Money.dollar(5);
        Money money1 = Money.dollar(5);
        assertThat(bank.addMoney(money1, money2).getBalance()).isEqualTo(10);
    }

    @Test
    @DisplayName("5$ - 6$ = 오류")
    void subtract_result_money_negative_then_throw_exception(){
        Money money1 = Money.dollar(5);
        Money money2 = Money.dollar(6);
        assertThatIllegalArgumentException()
           .isThrownBy(() -> bank.subtractMoney(money1, money2))
           .withMessageContaining("잔액", "부족");
    }

    @Test
    @DisplayName("5.25$ + 5.25$ = 10.50$ (소숫점 이하 2자리)")
    void add_decimal_point_money(){

    }
}
