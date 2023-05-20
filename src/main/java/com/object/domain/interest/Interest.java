package com.object.domain.interest;

import com.object.domain.money.Money;

public interface Interest {

    Money calculate(Money principal, Money current);
}
