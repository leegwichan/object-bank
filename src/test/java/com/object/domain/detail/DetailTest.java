package com.object.domain.detail;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.object.domain.money.Money;
import com.object.dto.DetailDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DetailTest {

    @DisplayName("정보를 싣어 Dto 객체를 정상적으로 반환할 수 있다")
    @Test
    void toDtoTest() {
        Detail detail = Detail.of(Money.of(100_000), Money.of(200_000), 3);
        DetailDto expected = new DetailDto(3, 200_000);

        DetailDto actual = detail.toDto();

        assertEquals(expected.getMoney(), actual.getMoney());
        assertEquals(expected.getYear(), actual.getYear());
    }
}