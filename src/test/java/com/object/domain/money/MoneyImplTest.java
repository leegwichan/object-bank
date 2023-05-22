package com.object.domain.money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MoneyImplTest {

    @DisplayName("금액이 음수인 경우에 예외를 던진다")
    @Test
    void createObjectTest_whenCreateNegativeAmount_throwIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> MoneyImpl.of(-1));
        assertEquals("금액은 음수가 될 수 없습니다", exception.getMessage());
    }

    @Nested
    @DisplayName("두 Money 객체의 동일성을 판별할 수 있다")
    class EqualTest {

        @Test
        @DisplayName("금액이 같은 객체는 equal 하다")
        void equalsTest_whenAmountIsEqual_returnTrue() {
            MoneyImpl money1 = MoneyImpl.of(100_000);
            MoneyImpl money2 = MoneyImpl.of(100_000);

            assertTrue(money1.equals(money2));
        }

        @Test
        @DisplayName("Money class가 아닌 객체는 항상 not equal 하다")
        void equalsTest_whenNotMoneyClass_returnFalse() {
            MoneyImpl money = MoneyImpl.of(100_000);
            Object string = "100_000";

            assertFalse(money.equals(string));
        }

        @Test
        @DisplayName("금액이 다른 객체는 Not Equal 하다")
        void equalsTest_whenAmountIsNotEqual_returnFalse() {
            MoneyImpl money1 = MoneyImpl.of(100_000);
            MoneyImpl money2 = MoneyImpl.of(100_001);

            assertFalse(money1.equals(money2));
        }

        @Test
        @DisplayName("같은 객체는 Equal하다.")
        void equalsTest_sameObject_returnTrue() {
            MoneyImpl money = MoneyImpl.of(100_000);

            assertTrue(money.equals(money));
        }
    }

    @Nested
    @DisplayName("같은 객체들은 같은 hashcode를 제공하여햐 한다.")
    class HashCodeTest {

        @Test
        @DisplayName("amount가 같은 두 객체는 같은 hashcode를 제공해야 한다.")
        void hashCodeTest_equalObject_returnSameHashcode() {
            MoneyImpl money1 = MoneyImpl.of(100_000);
            MoneyImpl money2 = MoneyImpl.of(100_000);

            assertTrue(money1.hashCode() == money2.hashCode());
        }

        @Test
        @DisplayName("하나의 객체는 항상 같은 hashcode를 제공해야 한다.")
        void hashCodeTest_oneObject_returnSameHashcode() {
            MoneyImpl money = MoneyImpl.of(100_000);

            assertTrue(money.hashCode() == money.hashCode());
        }
    }

    @Test
    @DisplayName("두 Money를 서로 더할 수 있다")
    void addTest() {
        long price1 = 100_000;
        long price2 = 200_000;
        MoneyImpl money1 = MoneyImpl.of(price1);
        MoneyImpl money2 = MoneyImpl.of(price2);
        MoneyImpl expected = MoneyImpl.of(price1 + price2);

        MoneyImpl actual = money1.add(money2);

        assertEquals(expected, actual);
    }

    @Nested
    @DisplayName("Money를 특정 배수만큼 곱할 수 있다")
    class MultiplyTest {
        @Test
        @DisplayName("금액에 양수를 곱할 수 있다")
        void multiplyTest_multiplyPositive() {
            long price = 100_000;
            double multiple = 2.245713;
            MoneyImpl money = MoneyImpl.of(price);
            MoneyImpl expected = MoneyImpl.of((long) (price * multiple));

            MoneyImpl actual = money.multiply(multiple);

            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("금액에 음수를 곱할 수 없다")
        void multiplyTest_multiplyNegative_throwIllegalArgumentException() {
            long price = 100_000;
            double multiple = -2.245713;
            MoneyImpl money = MoneyImpl.of(price);

            Exception exception = assertThrows(IllegalArgumentException.class, () -> money.multiply(multiple));
            assertEquals("금액에 음수를 곱할 수 없습니다", exception.getMessage());
        }
    }




}