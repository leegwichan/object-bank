package com.object.domain.account;

import com.object.domain.detail.Detail;
import com.object.domain.interest.Interest;
import com.object.domain.money.Money;
import com.object.dto.AccountDto;
import com.object.dto.DetailDto;
import com.object.exception.message.AccountExceptionMessage;
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
        this.principal = Objects.requireNonNull(principal, AccountExceptionMessage.PRINCIPAL_NOT_NULL.getMessage());
        this.current = Objects.requireNonNull(principal, AccountExceptionMessage.PRINCIPAL_NOT_NULL.getMessage());
        this.interest = Objects.requireNonNull(interest, AccountExceptionMessage.INTEREST_NOT_NULL.getMessage());
        this.details = new ArrayList<>();
    }

    public static Account of(Money principal, Interest interest) {
        return new Account(principal, interest);
    }

    public AccountDto progress(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException(AccountExceptionMessage.PROGRESS_POSITIVE.getMessage());
        }

        while (details.size() < year) {
            Money interest = this.interest.calculate(principal, current);
            current = current.add(interest);
            details.add(Detail.of(interest, current, details.size()));
        }

        return new AccountDto(details.stream().limit(year).map(DetailDto::from).collect(Collectors.toList()));
    }

    public List<Detail> getDetails() {
        return List.copyOf(details);
    }
}
