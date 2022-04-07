package com.nhnacadmy.bank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import com.nhnacademy.bank.Bank;
import com.nhnacademy.currency.Currency;
import com.nhnacademy.money.Money;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankTest {
    Bank bank;
    Currency currency;

    @BeforeEach
    void setUp() {
        bank = new Bank();
    }

    @Test
    @DisplayName("금액을 더하는 기능 구현.")
    void add_money() {
        Money money1 = Money.won(1000);
        Money money2 = Money.won(1000);
        assertThat(bank.addMoney(money1, money2).getBalance()).isEqualTo(2000);
    }

    @Test
    @DisplayName("돈의 실제값이 같은지 확인.")
    void eqauls_money() {
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
    void subtract_result_money_negative_then_throw_exception() {
        Money money1 = Money.dollar(5);
        Money money2 = Money.dollar(6);
        assertThatIllegalArgumentException()
            .isThrownBy(() -> bank.subtractMoney(money1, money2))
            .withMessageContaining("잔액", "부족");
    }

    @Test
    @DisplayName("5.25$ + 5.25$ = 10.50$ (소숫점 이하 2자리)")
    void add_decimal_point_money() {
        Money money1 = Money.dollar(5.256);
        Money money2 = Money.dollar(5.256);
        assertThat(bank.addMoney(money1, money2).getBalance()).isEqualTo(10.51);
    }

    @Test
    @DisplayName("통화는 달러화와 원화만이 존재하고, 환율은 1달러 <-> 1,000원")
    void exchange_dallor_or_won() {
        Money money1 = Money.won(1);
        assertThat(bank.dollarToWon(money1).getBalance()).isEqualTo(1000);
    }


    @Test
    @DisplayName("5.25$ -> 5,250원")
    void dallor_exchange_to_won() {
        Money money2 = Money.dollar(5.25);
        assertThat(bank.dollarToWon(money2).getBalance()).isEqualTo(5_250);
    }

    @Test
    @DisplayName("5.255$ -> 5,260원, 5.251$ -> 5,250원")
    void round_dollar_exchanged_to_won() {
        Money money1 = Money.dollar(5.255);
        Money money2 = Money.dollar(5.251);
        assertThat(bank.dollarToWon(money1).getBalance()).isEqualTo(5_260);
        assertThat(bank.dollarToWon(money2).getBalance()).isEqualTo(5_250);
    }

    @Test
    @DisplayName("$0.005이상 -> $0.01 반올림")
    void round_won_exchanged_to_dollar() {
        Money money1 = Money.won(54221);
        Money money2 = Money.won(54228);

        assertThat(bank.wonToDollar(money1).getBalance()).isEqualTo(54.220);
        assertThat(bank.wonToDollar(money2).getBalance()).isEqualTo(54.230);
    }

    @Test
    @DisplayName("유로(1유로당 1200원) -> 원으로 환전")
    void euro_exchanged_to_won(){
        Money money1 = Money.euro(1);
        assertThat(bank.euroToWon(money1).getBalance()).isEqualTo(1200);
    }

    @Test
    @DisplayName("유로 -> 달러로 환전")
    void euro_exchanged_to_dollar(){
        Money money1 = Money.euro(1);
        assertThat(bank.euroToDollar(money1).getBalance()).isEqualTo(1.2);
    }

    @Test
    @DisplayName("달러 -> 유로로 환전")
    void dollar_exchanged_to_euro(){
        Money dollar = Money.dollar(1.2);
        assertThat(bank.dollarToEuro(dollar).getBalance()).isEqualTo(1);
    }

    @Test
    @DisplayName("원 -> 유로로 환전")
    void won_exchanged_to_euro(){
        Money won = Money.won(1200);
        assertThat(bank.wonToEuro(won).getBalance()).isEqualTo(1);
    }
}