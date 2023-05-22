package com.object.domain.mock;

import com.object.domain.money.Money;
import lombok.ToString;

@ToString
public class MockMoney implements Money {

    private final long amount;

    public MockMoney(long amount) {
        this.amount = amount;
    }

    @Override
    public Money add(Money money) {
        return new MockMoney(money.getAmount() + amount);
    }

    @Override
    public Money multiply(double multiple) {
        return new MockMoney((long) (amount * multiple));
    }

    @Override
    public long getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof MockMoney)) {
            return false;
        }

        return this.amount == ((MockMoney) o).amount;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(amount).intValue();
    }
}
