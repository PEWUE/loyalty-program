package com.PEWUE.loyalty_program.exception;

import org.springframework.http.HttpStatus;

public class ProgramNotFoundException extends ApplicationException {
    public ProgramNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
