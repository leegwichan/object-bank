package com.object.domain.interest;

import com.object.domain.money.Money;

public class DynamicInterest implements Interest {

    private final double initialRate;
    private int count = 0;

    private DynamicInterest(double initialRate) {
        this.initialRate = initialRate;
    }

    public static DynamicInterest of(double initialRate) {
        return new DynamicInterest(initialRate);
    }

    @Override
    public Money calculate(Money principal, Money current) {
        count++;
        double currentRate = initialRate * count;
        return principal.multiply(currentRate);
    }
}
