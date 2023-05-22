package com.object.domain.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.object.domain.mock.MockMoney;
import com.object.domain.mock.NoInterest;
import com.object.domain.money.Money;
import com.object.dto.AccountDto;
import com.object.dto.DetailDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AccountTest {

    @Nested
    @DisplayName("Account 객체 생성시에는 null 값의 인자가 들어와서는 안된다")
    class CreateTest {
        @Test
        @DisplayName("객체 생성시에 원금을 null로 입력하면 예외를 발생시킨다")
        void createTest_principalIsNull_throwNullPointerException() {
            Exception exception = assertThrows(NullPointerException.class, () -> Account.of(null, new NoInterest()));
            assertEquals("[ERROR] 원금은 null이 아니어야 합니다", exception.getMessage());
        }

        @Test
        @DisplayName("객체 생성시에 이익 기능을 null로 입력하면 예외를 발생시킨다")
        void createTest_interestIsNull_throwNullPointerException() {
            Exception exception = assertThrows(NullPointerException.class, () -> Account.of(new MockMoney(1_000), null));
            assertEquals("[ERROR] 이익은 null이 아니어야 합니다", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("입력 받은 년수만큼의 내역을 정상적으로 출력할 수 있다")
    class ProgressTest {

        @Test
        @DisplayName("특정 년수만큼의 내역을 1회 요청하였을 때 내역을 반환한다.")
        void progressTest_doOneTime() {
            long principal = 100_000;
            Account account = Account.of(new MockMoney(principal), new NoInterest());

            AccountDto actual = account.progress(30);

            assertEquals(30, actual.getDetails().size());
            for (DetailDto dto : actual.getDetails()) {
                assertEquals(principal , dto.getMoney());
            }
        }

        @Test
        @DisplayName("특정 년수만큼의 내역을 2회 요청하였을 때 (높은 숫자 먼저) 내역을 반환한다.")
        void progressTest_doLowerFirstHigherSecond() {
            long principal = 100_000;
            Account account = Account.of(new MockMoney(principal), new NoInterest());

            account.progress(30);
            AccountDto actual = account.progress(40);

            assertEquals(40, actual.getDetails().size());
            for (DetailDto dto : actual.getDetails()) {
                assertEquals(principal , dto.getMoney());
            }
        }

        @Test
        @DisplayName("특정 년수만큼의 내역을 2회 요청하였을 때 (낮은 숫자 먼저) 내역을 반환한다.")
        void progressTest_doHigherFirstLowerSecond() {
            long principal = 100_000;
            Account account = Account.of(new MockMoney(principal), new NoInterest());

            account.progress(40);
            AccountDto actual = account.progress(30);

            assertEquals(30, actual.getDetails().size());
            for (DetailDto dto : actual.getDetails()) {
                assertEquals(principal , dto.getMoney());
            }
        }

        @Test
        @DisplayName("progress() 에 음수를 넣었을 경우 예외를 던진다.")
        void progressTest_inputNonPositiveInt_throwIllegalArgumentException() {
            Account account = Account.of(new MockMoney(100_000), new NoInterest());

            Exception exception = assertThrows(IllegalArgumentException.class, () -> account.progress(-5));
            assertEquals("[ERROR] 진행 년수는 양수이어야 합니다.", exception.getMessage());
        }
    }


}