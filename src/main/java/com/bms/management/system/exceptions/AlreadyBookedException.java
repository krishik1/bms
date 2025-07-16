package com.bms.management.system.exceptions;

public class AlreadyBookedException extends RuntimeException {
    public AlreadyBookedException(String s) {
        super(s);
    }
}
