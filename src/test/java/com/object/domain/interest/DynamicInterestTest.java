package com.object.domain.interest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.object.domain.mock.MockMoney;
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
        Money expectedFirstYear = new MockMoney((long) (principal * initialRate * 1));
        Money expectedSecondYear = new MockMoney((long) (principal * initialRate * 2));

        Money actualFirstYear = interest.calculate(new MockMoney(principal), new MockMoney(current));
        Money actualSecondYear = interest.calculate(new MockMoney(principal), new MockMoney(current));

        assertEquals(expectedFirstYear, actualFirstYear);
        assertEquals(expectedSecondYear, actualSecondYear);
    }
}