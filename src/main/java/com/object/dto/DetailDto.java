package com.object.dto;

import com.object.domain.detail.Detail;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DetailDto {

    private final int year;
    private final long money;
}
