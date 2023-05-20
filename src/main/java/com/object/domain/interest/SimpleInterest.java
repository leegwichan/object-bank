package com.object.domain.interest;

import com.object.domain.money.Money;

public class SimpleInterest implements Interest {

    private final double rate;

    private SimpleInterest(double rate) {
        this.rate = rate;
    }

    public static SimpleInterest of(double rate) {
        return new SimpleInterest(rate);
    }

    @Override
    public Money calculate(Money principal, Money current) {
        return principal.multiply(rate);
    }
}
