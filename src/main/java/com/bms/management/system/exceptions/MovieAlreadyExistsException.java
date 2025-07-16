package com.bms.management.system.exceptions;

public class MovieAlreadyExistsException extends RuntimeException {
    public MovieAlreadyExistsException(String name) {
        super("Movie Already Exists With Name : " + name);
    }
}
