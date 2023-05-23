package com.object.domain.interest;

import static org.junit.jupiter.api.Assertions.*;

import com.object.domain.mock.MockMoney;
import com.object.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompoundInterestTest {

    @DisplayName("복리를 계산할 수 있다")
    @Test
    void calculateTest_periodOneYear() {
        long principal = 100_000L;
        long current = 150_000L;
        double rate = 0.05;
        CompoundInterest interest = CompoundInterest.of(rate);
        Money expect = new MockMoney((long) (current * rate));

        Money actual = interest.calculate(new MockMoney(principal), new MockMoney(current));

        assertEquals(expect, actual);
    }
}