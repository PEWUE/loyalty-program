package com.PEWUE.loyalty_program.exception;

public class MembershipNotFoundException extends RuntimeException {
  public MembershipNotFoundException(String message) {
    super(message);
  }
}
