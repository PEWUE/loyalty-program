package com.PEWUE.loyalty_program.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyMemberOfProgramException extends ApplicationException {
    public UserAlreadyMemberOfProgramException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
