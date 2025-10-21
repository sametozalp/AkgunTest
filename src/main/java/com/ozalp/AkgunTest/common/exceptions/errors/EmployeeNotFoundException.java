package com.ozalp.AkgunTest.common.exceptions.errors;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
