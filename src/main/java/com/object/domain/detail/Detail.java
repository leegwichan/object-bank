package com.object.domain.detail;

import com.object.domain.money.Money;

public class Detail {

    private Money deposit;
    private Money total;
    private int year;

    private Detail(Money deposit, Money total, int year) {
        this.deposit = deposit;
        this.total = total;
        this.year = year;
    }

    public static Detail of(Money deposit, Money total, int year) {
        return new Detail(deposit, total, year);
    }

    public long getTotal() {
        return total.getAmount();
    }

    public int getYear() {
        return year;
    }
}
