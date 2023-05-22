package com.object.domain.interest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.object.domain.mock.MockMoney;
import com.object.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleInterestTest {

    @Test
    @DisplayName("단리를 계산할 수 있다.")
    void calculateTest() {
        long principal = 100_000L;
        long current = 150_000L;
        double rate = 0.05;
        SimpleInterest interest = SimpleInterest.of(rate);
        Money expected = new MockMoney((long) (principal * rate));

        Money actual = interest.calculate(new MockMoney(principal), new MockMoney(current));

        assertEquals(expected, actual);
    }
}