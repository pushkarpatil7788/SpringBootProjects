package com.infosys.CoursePostgreSqlRest.exception;

import com.infosys.CoursePostgreSqlRest.model.CourseResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDate;

@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            org.springframework.web.context.request.WebRequest request) {

        CourseResponse response = new CourseResponse();
        response.setStatusCode(400);
        response.setStatusMsg(ex.getBindingResult().toString());
        response.setResponseDate(LocalDate.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(CourseException.class)
    public ResponseEntity<CourseResponse> exceptionHandler(CourseException courseException) {
        CourseResponse response = new CourseResponse();
        response.setStatusCode(500);
        response.setStatusMsg("Course Not Found: " + courseException.getMessage());
        response.setResponseDate(LocalDate.now());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
