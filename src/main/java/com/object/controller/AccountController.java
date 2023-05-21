package com.object.controller;

import com.object.domain.account.Account;
import com.object.domain.interest.CompoundInterest;
import com.object.domain.interest.DynamicInterest;
import com.object.domain.interest.SimpleInterest;
import com.object.domain.money.Money;
import com.object.dto.AccountDto;
import com.object.view.OutputView;
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
    private final OutputView output = new OutputView();

    public AccountController() {
        accounts = new ArrayList<>();
        accounts.add(Account.of(PRINCIPAL, BASIC_INTEREST));
        accounts.add(Account.of(PRINCIPAL, CLASSIC_INTEREST));
        accounts.add(Account.of(PRINCIPAL, LINER_INTEREST));
        accounts.add(Account.of(PRINCIPAL, DYNAMIC_INTEREST));
    }

    public final void run() {
        List<AccountDto> accountDtos = accounts.stream()
                .map(account -> account.progress(YEAR))
                .collect(Collectors.toList());

        output.printAccounts(accountDtos, PRINCIPAL.getAmount());
    }
}
