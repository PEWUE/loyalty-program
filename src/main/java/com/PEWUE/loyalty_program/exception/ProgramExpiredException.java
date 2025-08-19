package com.PEWUE.loyalty_program.exception;

public class ProgramExpiredException extends RuntimeException {
    public ProgramExpiredException(String message) {
        super(message);
    }
}
