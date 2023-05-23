package com.object.domain.interest;

import com.object.domain.money.Money;

public class CompoundInterest implements Interest{

    private final double rate;

    private CompoundInterest(double rate) {
        this.rate = rate;
    }

    public static CompoundInterest of (double rate) {
        return new CompoundInterest(rate);
    }

    @Override
    public Money calculate(Money principal, Money current) {
        return current.multiply(rate);
    }
}
