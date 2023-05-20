package com.object.domain.interest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.object.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DynamicInterestTest {

    @Test
    @DisplayName("이율이 년마다 늘어나는 중에 이자를 계산할 수 있다")
    void calculateTest() {
        long principal = 100_000L;
        long current = 150_000L;
        double initialRate = 0.05;
        DynamicInterest interest = DynamicInterest.of(initialRate);
        Money expectedFirstYear = Money.of((long) (principal * initialRate * 1));
        Money expectedSecondYear = Money.of((long) (principal * initialRate * 2));

        Money actualFirstYear = interest.calculate(Money.of(principal), Money.of(current));
        Money actualSecondYear = interest.calculate(Money.of(principal), Money.of(current));

        assertEquals(expectedFirstYear, actualFirstYear);
        assertEquals(expectedSecondYear, actualSecondYear);
    }
}