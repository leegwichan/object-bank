package com.object.view;

import com.object.dto.AccountDto;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printAccounts(List<AccountDto> accounts) {
        List<List<Long>> accountDetails = accounts.stream()
                .map(AccountDto::getTotalMoneys)
                .collect(Collectors.toList());

        System.out.printf("\n※ 예금 비교하기 ※\n\n");
        System.out.printf(" YEAR| BASIC_INTEREST|CLASSIC_INTEREST|  LINER_INTEREST|DYNAMIC_INTEREST|\n");
        for (int i=0; i<accountDetails.get(0).size(); i++) {
            System.out.printf("%5d  ", i);
            for (List<Long> details : accountDetails) {
                System.out.printf("%14d   ", details.get(i));
            }
            System.out.print("\n");
        }
    }
}
