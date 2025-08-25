package com.PEWUE.loyalty_program.exception;

public class ProgramAlreadyExistsException extends RuntimeException {
    public ProgramAlreadyExistsException(String message) {
        super(message);
    }
}
