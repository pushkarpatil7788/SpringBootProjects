package com.infosys.postgrerest.Exception;

import com.infosys.postgrerest.model.BookResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BookResponse> exceptionHandler(BookException bookException) {
        BookResponse response = new BookResponse();
        response.setStatusCode(404);
        response.setStatusMessage(bookException.getMessage());
        response.setResponseDate(LocalDate.now());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        BookResponse response = new BookResponse();
        response.setStatusCode(400);
        response.setStatusMessage("Validation Failed: " + ex.getMessage());
        response.setResponseDate(LocalDate.now());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
