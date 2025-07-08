package com.infosys.PostgreSqlRest.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter

public class EmployeeException {

    private final String Message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public EmployeeException(String message, Throwable throwable, HttpStatus httpStatus) {
        Message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }
}