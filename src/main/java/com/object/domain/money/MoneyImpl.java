package com.object.domain.money;

public class MoneyImpl implements Money {
    public static final Money ZERO = Money.of(0);

    private final long amount;

    private MoneyImpl(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("금액은 음수가 될 수 없습니다");
        }

        this.amount = amount;
    }
    public static MoneyImpl of(long amount) {
        return new MoneyImpl(amount);
    }

    public MoneyImpl add(Money money) {
        return new MoneyImpl(money.getAmount() + this.amount);
    }

    public MoneyImpl multiply(double multiple) {
        if (multiple < 0) {
            throw new IllegalArgumentException("금액에 음수를 곱할 수 없습니다");
        }
        return new MoneyImpl((long) (this.amount * multiple));
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof MoneyImpl)) {
            return false;
        }

        return this.amount == ((MoneyImpl) o).amount;
    }

    @Override
    public int hashCode() {
        return Long.valueOf(amount).intValue();
    }
}
