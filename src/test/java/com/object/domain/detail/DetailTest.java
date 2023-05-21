package com.object.domain.detail;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.object.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DetailTest {

    private static final long DEPOSIT = 1_000;
    private static final long TOTAL = 100_000;
    private static final int YEAR = 3;

    private final Detail detail = Detail.of(Money.of(DEPOSIT), Money.of(TOTAL), YEAR);

    @DisplayName("입금 후 전체 금액 정보를 보여줄 수 있다")
    @Test
    void getTotalTest() {
        assertEquals(detail.getTotal(), TOTAL);
    }

    @DisplayName("예금 중 몇년째 입금인지 알 수 있다")
    @Test
    void getYearTest() {
        assertEquals(detail.getYear(), YEAR);
    }
}