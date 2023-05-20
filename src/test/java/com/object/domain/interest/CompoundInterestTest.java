package com.object.domain.interest;

import static org.junit.jupiter.api.Assertions.*;

import com.object.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompoundInterestTest {

    @DisplayName("1년 단위의 복리를 계산할 수 있다")
    @Test
    void calculateTest_periodOneYear() {
        long principal = 100_000L;
        long current = 150_000L;
        double rate = 0.05;
        CompoundInterest interest = CompoundInterest.of(rate);
        Money expect = Money.of((long) (current * rate));

        Money actual = interest.calculate(Money.of(principal), Money.of(current));

        assertEquals(expect, actual);
    }

    @DisplayName("2년 단위의 복리를 계산할 수 있다")
    @Test
    void calculateTest_periodTwoYear() {
        long principal = 100_000L;
        long current = 150_000L;
        double rate = 0.05;
        int periodYear = 2;
        CompoundInterest interest = CompoundInterest.of(rate, periodYear);
        Money expectSecondYear = Money.of((long) (current * rate));

        Money firstYear = interest.calculate(Money.of(principal), Money.of(current));
        Money secondYear = interest.calculate(Money.of(principal), Money.of(current));

        assertEquals(Money.ZERO, firstYear);
        assertEquals(expectSecondYear, secondYear);
    }
}