package com.object.domain.interest;

import com.object.domain.money.Money;

public class CompoundInterest implements Interest{

    private static final int DEFAULT_PERIOD = 1;

    private final double rate;
    private final int periodYear;
    private int count = 0;

    private CompoundInterest(double rate, int periodYear) {
        this.rate = rate;
        this.periodYear = periodYear;
    }

    public static CompoundInterest of(double rate, int periodYear) {
        return new CompoundInterest(rate, periodYear);
    }

    public static CompoundInterest of (double rate) {
        return new CompoundInterest(rate, DEFAULT_PERIOD);
    }

    @Override
    public Money calculate(Money principal, Money current) {
        count++;
        if (count % periodYear != 0) {
            return Money.ZERO;
        }

        return current.multiply(rate);
    }
}
