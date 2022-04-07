package com.nhnacademy.money;

import com.nhnacademy.exceptions.MoneyNegativeException;

public class Money {
    long money;

    public Money(long money) {
        if(money < 0){
            throw new MoneyNegativeException("금액은 0원미만일 수 없습니다.");
        }
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Money money1 = (Money) o;

        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return (int) (money ^ (money >>> 32));
    }
}
