package com.object.domain.money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Nested
    @DisplayName("두 Money 객체의 동일성을 판별할 수 있다")
    class EqualTest {

        @Test
        @DisplayName("금액이 같은 객체는 equal 하다")
        void equalsTest_whenAmountIsEqual_returnTrue() {
            Money money1 = Money.of(100_000);
            Money money2 = Money.of(100_000);

            assertTrue(money1.equals(money2));
        }

        @Test
        @DisplayName("Money class가 아닌 객체는 항상 not equal 하다")
        void equalsTest_whenNotMoneyClass_returnFalse() {
            Money money = Money.of(100_000);
            Object string = "100_000";

            assertFalse(money.equals(string));
        }

        @Test
        @DisplayName("금액이 다른 객체는 Not Equal 하다")
        void equalsTest_whenAmountIsNotEqual_returnFalse() {
            Money money1 = Money.of(100_000);
            Money money2 = Money.of(100_001);

            assertFalse(money1.equals(money2));
        }

        @Test
        @DisplayName("같은 객체는 Equal하다.")
        void equalsTest_sameObject_returnTrue() {
            Money money = Money.of(100_000);

            assertTrue(money.equals(money));
        }
    }

    @Nested
    @DisplayName("같은 객체들은 같은 hashcode를 제공하여햐 한다.")
    class HashCodeTest {

        @Test
        @DisplayName("amount가 같은 두 객체는 같은 hashcode를 제공해야 한다.")
        void hashCodeTest_equalObject_returnSameHashcode() {
            Money money1 = Money.of(100_000);
            Money money2 = Money.of(100_000);

            assertTrue(money1.hashCode() == money2.hashCode());
        }

        @Test
        @DisplayName("하나의 객체는 항상 같은 hashcode를 제공해야 한다.")
        void hashCodeTest_oneObject_returnSameHashcode() {
            Money money = Money.of(100_000);

            assertTrue(money.hashCode() == money.hashCode());
        }
    }

    @Test
    @DisplayName("두 Money를 서로 더할 수 있다")
    void addTest() {
        long price1 = 100_000;
        long price2 = 200_000;
        Money money1 = Money.of(price1);
        Money money2 = Money.of(price2);
        Money expected = Money.of(price1 + price2);

        Money actual = money1.add(money2);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Money를 특정 배수만큼 곱할 수 있다")
    void multiply() {
        long price = 100_000;
        double multiple = 2.245713;
        Money money = Money.of(price);
        Money expected = Money.of((long) (price * multiple));

        Money actual = money.multiply(multiple);

        assertEquals(expected, actual);
    }


}