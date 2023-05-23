package com.object.domain.account;

import com.object.domain.interest.Interest;
import com.object.domain.money.Money;
import com.object.dto.AccountDto;
import com.object.dto.DetailDto;
import com.object.exception.message.AccountExceptionMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {

    private final Money principal;
    private final Interest interest;

    private Account(Money principal, Interest interest) {
        this.principal = Objects.requireNonNull(principal, AccountExceptionMessage.PRINCIPAL_NOT_NULL.getMessage());
        this.interest = Objects.requireNonNull(interest, AccountExceptionMessage.INTEREST_NOT_NULL.getMessage());

    }

    public static Account of(Money principal, Interest interest) {
        return new Account(principal, interest);
    }

    public AccountDto progress(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException(AccountExceptionMessage.PROGRESS_POSITIVE.getMessage());
        }

        List<DetailDto> detailDtos = new ArrayList<>();
        detailDtos.add(new DetailDto(0, principal.getAmount()));
        Money current = principal;
        for (int curYear = 1; curYear <= year; curYear++) {
            Money interest = this.interest.calculate(principal, current);
            current = current.add(interest);
            detailDtos.add(new DetailDto(curYear, current.getAmount()));
        }

        return new AccountDto(detailDtos);
    }
}
