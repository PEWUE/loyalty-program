package com.PEWUE.loyalty_program.exception;

import org.springframework.http.HttpStatus;

public class RewardNotFoundException extends ApplicationException {
    public RewardNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
