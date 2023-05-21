package com.object.domain.account;

import com.object.domain.detail.Detail;
import com.object.domain.interest.Interest;
import com.object.domain.money.Money;
import com.object.dto.AccountDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Account {

    private final Money principal;
    private Money current;
    private Interest interest;
    private final List<Detail> details;

    private Account(Money principal, Interest interest) {
        this.principal = Objects.requireNonNull(principal);
        this.current = Objects.requireNonNull(principal);
        this.interest = Objects.requireNonNull(interest);
        this.details = new ArrayList<>();
    }

    public static Account of(Money principal, Interest interest) {
        return new Account(principal, interest);
    }

    public AccountDto progress(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("[ERROR] 진행 년수는 양수이어야 합니다.");
        }

        while (details.size() < year) {
            Money interest = this.interest.calculate(principal, current);
            current = current.add(interest);
            details.add(Detail.of(interest, current, details.size()));
        }

        return new AccountDto(details.stream().limit(year).map(Detail::toDto).collect(Collectors.toList()));
    }
}
