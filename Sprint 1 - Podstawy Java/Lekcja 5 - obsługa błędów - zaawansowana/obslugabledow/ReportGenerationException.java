package org.example.obslugabledow;

public class ReportGenerationException extends RuntimeException {

    private static final int ERROR_CODE = 1;
    public ReportGenerationException() {
        super(String.valueOf(ERROR_CODE));
    }
}
