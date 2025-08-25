package com.PEWUE.loyalty_program.exception;

public class ProgramAlreadyExists extends RuntimeException {
    public ProgramAlreadyExists(String message) {
        super(message);
    }
}
