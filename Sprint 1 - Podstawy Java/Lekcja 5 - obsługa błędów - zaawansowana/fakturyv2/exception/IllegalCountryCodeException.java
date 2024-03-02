package org.example.fakturyv2.exception;

public class IllegalCountryCodeException extends RuntimeException {

    public IllegalCountryCodeException(String message) {
        super(message);
    }
}
