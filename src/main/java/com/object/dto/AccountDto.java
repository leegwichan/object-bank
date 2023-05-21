package com.object.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class AccountDto {

    private final List<DetailDto> details;

    public List<Long> getTotalMoneys() {
        return details.stream().map(detailDto -> detailDto.getMoney())
                .collect(Collectors.toList());
    }
}
