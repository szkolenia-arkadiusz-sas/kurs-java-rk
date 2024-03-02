package org.example.fakturyv2.validator;

import org.example.fakturyv2.exception.EmptyCoutnryCodeException;
import org.example.fakturyv2.exception.IllegalCountryCodeException;

import java.util.ArrayList;
import java.util.List;

public class CountryCodeValidator {

    public static void validate(String countryCode) {
        validateIfCountryCodeIsNotEmpty(countryCode);
        validateIfCountryCodeIsHandled(countryCode);
    }

    private static void validateIfCountryCodeIsNotEmpty(String countryCode) {
        if ("".equals(countryCode)) {
            throw new EmptyCoutnryCodeException("Empty country code!");
        }
    }

    private static void validateIfCountryCodeIsHandled(String countryCode) {
        List<String> availableCountryCode = List.of("PL", "DE", "US");
        if (!availableCountryCode.contains(countryCode)) {
            throw new IllegalCountryCodeException(countryCode + " is not a valid country code.");
        }
    }
}
