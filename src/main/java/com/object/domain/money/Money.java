package com.object.domain.money;

public class Money {

    public static final Money ZERO = Money.of(0);

    private final long amount;

    private Money(long amount) {
        this.amount = amount;
    }
    public static Money of(long amount) {
        return new Money(amount);
    }

    public Money add(Money money) {
        return new Money(money.amount + this.amount);
    }

    public Money multiply(double multiple) {
        return new Money((long) (this.amount * multiple));
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
