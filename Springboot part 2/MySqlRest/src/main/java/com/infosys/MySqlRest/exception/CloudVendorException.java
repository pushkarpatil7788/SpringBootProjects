package com.infosys.MySqlRest.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter

public class CloudVendorException {

    private final String Message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public CloudVendorException(String message, Throwable throwable, HttpStatus httpStatus) {
        Message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }
}