package com.object.exception;

public enum ExceptionMessage {


    PRINCIPAL_NOT_NULL("[ERROR] 원금은 null이 아니어야 합니다"),
    INTEREST_NOT_NULL("[ERROR] 이익은 null이 아니어야 합니다"),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
