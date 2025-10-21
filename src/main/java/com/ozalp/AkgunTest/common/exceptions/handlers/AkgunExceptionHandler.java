package com.ozalp.AkgunTest.common.exceptions.handlers;

import com.ozalp.AkgunTest.common.results.ErrorResult;
import com.ozalp.AkgunTest.common.exceptions.errors.EmployeeNotFoundException;
import com.ozalp.AkgunTest.common.exceptions.errors.RulesException;
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

    @ExceptionHandler(RulesException.class)
    ResponseEntity<?> rulesException(RulesException exception) {
        return new ResponseEntity<>(new ErrorResult(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
