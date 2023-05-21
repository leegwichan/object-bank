package com.object.exception.message;

import com.object.exception.ExceptionCode;

public enum AccountExceptionMessage implements ExceptionCode {
    PRINCIPAL_NOT_NULL("[ERROR] 원금은 null이 아니어야 합니다"),
    INTEREST_NOT_NULL("[ERROR] 이익은 null이 아니어야 합니다"),

    PROGRESS_POSITIVE("[ERROR] 진행 년수는 양수이어야 합니다.")
    ;

    private String message;

    AccountExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
