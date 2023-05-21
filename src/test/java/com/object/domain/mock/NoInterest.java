package com.object.domain.mock;

import com.object.domain.interest.Interest;
import com.object.domain.money.Money;

public class NoInterest implements Interest {
    @Override
    public Money calculate(Money principal, Money current) {
        return Money.ZERO;
    }
}
