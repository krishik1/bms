package com.bms.management.system.exceptions;

public class EmailAlreadyExitsException extends RuntimeException {

    public EmailAlreadyExitsException(String email) {
        super("Customer with email " + email + " already exists.");
    }


}
