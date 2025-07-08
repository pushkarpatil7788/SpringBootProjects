package com.infosys.PostgreSqlRest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandeler {
    @ExceptionHandler(value = {EmployeeNotFoundException.class})
    public ResponseEntity<Object> handleCloudVendorNotFoundException(EmployeeNotFoundException cloudVendorNotFoundException) {
        EmployeeException cloudVendorException = new EmployeeException(
                cloudVendorNotFoundException.getMessage(),
                cloudVendorNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);
    }

}
