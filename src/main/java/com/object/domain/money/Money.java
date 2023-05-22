package com.object.domain.money;

public interface Money {
    Money ZERO = MoneyImpl.ZERO;
    static Money of(long amount) {
        return MoneyImpl.of(amount);
    }

    Money add(Money money);
    Money multiply(double multiple);
    long getAmount();
}
