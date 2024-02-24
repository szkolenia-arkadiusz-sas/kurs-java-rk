package org.example.fakturyv2;

public class InvalidCurrencyRateException extends RuntimeException {

    public InvalidCurrencyRateException(double eurRate) {
        super("Niepoprawny kurs walut! EUR: " + eurRate);
    }

}
