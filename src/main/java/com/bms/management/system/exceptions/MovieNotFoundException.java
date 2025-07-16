package com.bms.management.system.exceptions;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long id) {
        super("Movie Not Found With Id : "+id);
    }
}
