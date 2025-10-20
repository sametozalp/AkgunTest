package com.ozalp.AkgunTest.exceptions.handlers;

import com.ozalp.AkgunTest.common.results.ErrorResult;
import com.ozalp.AkgunTest.exceptions.errors.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AkgunExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    ResponseEntity<?> employeeNotFound(EmployeeNotFoundException exception) {
        return new ResponseEntity<>(new ErrorResult(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
