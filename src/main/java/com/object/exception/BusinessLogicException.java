package com.object.exception;

public class BusinessLogicException extends RuntimeException {

    public BusinessLogicException(ExceptionMessage exceptionCode) {
        super(exceptionCode.getMessage());
    }
}
