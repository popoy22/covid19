package com.covid.api.exceptions;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(Long id) {
        super("Could not find country " + id);
    }
}
