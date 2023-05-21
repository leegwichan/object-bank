package com.object.controller;

import com.object.domain.account.Account;
import com.object.domain.interest.CompoundInterest;
import com.object.domain.interest.DynamicInterest;
import com.object.domain.interest.SimpleInterest;
import com.object.domain.money.Money;
import com.object.dto.AccountDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountController {

    private static final Money PRINCIPAL = Money.of(1_000);
    private static final int YEAR = 60;

    private static final CompoundInterest BASIC_INTEREST = CompoundInterest.of(0.025);
    private static final CompoundInterest CLASSIC_INTEREST = CompoundInterest.of(0.08);
    private static final SimpleInterest LINER_INTEREST = SimpleInterest.of(0.5);
    private static final DynamicInterest DYNAMIC_INTEREST = DynamicInterest.of(0.05);

    private final List<Account> accounts;

    public AccountController() {
        accounts = new ArrayList<>();
        accounts.add(Account.of(PRINCIPAL, BASIC_INTEREST));
        accounts.add(Account.of(PRINCIPAL, CLASSIC_INTEREST));
        accounts.add(Account.of(PRINCIPAL, LINER_INTEREST));
        accounts.add(Account.of(PRINCIPAL, DYNAMIC_INTEREST));
    }

    public final void run() {

        List<List<Long>> accountDetails = accounts.stream()
                .map(account -> account.progress(YEAR))
                .map(AccountDto::getTotalMoneys)
                .collect(Collectors.toList());

        System.out.printf("\n※ 예금 비교하기 ※ (초기 금액 : %d)\n\n", PRINCIPAL.getAmount());
        System.out.printf(" YEAR| BASIC_INTEREST|CLASSIC_INTEREST|  LINER_INTEREST|DYNAMIC_INTEREST|\n");
        for (int i=0; i<YEAR; i++) {
            System.out.printf("%5d  ", i+1);
            for (List<Long> details : accountDetails) {
                System.out.printf("%14d   ", details.get(i));
            }
            System.out.print("\n");
        }

    }
}
