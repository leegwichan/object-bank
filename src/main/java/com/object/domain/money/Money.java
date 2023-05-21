package com.object.domain.money;

public class Money {

    public static final Money ZERO = Money.of(0);

    private final long amount;

    private Money(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("금액은 음수가 될 수 없습니다");
        }

        this.amount = amount;
    }
    public static Money of(long amount) {
        return new Money(amount);
    }

    public Money add(Money money) {
        return new Money(money.amount + this.amount);
    }

    public Money multiply(double multiple) {
        if (multiple < 0) {
            throw new IllegalArgumentException("금액에 음수를 곱할 수 없습니다");
        }
        return new Money((long) (this.amount * multiple));
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Money)) {
            return false;
        }

        return this.amount == ((Money) o).amount;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(amount).intValue();
    }
}
