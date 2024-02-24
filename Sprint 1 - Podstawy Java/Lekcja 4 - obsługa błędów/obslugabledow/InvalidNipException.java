package org.example.obslugabledow;

public class InvalidNipException extends RuntimeException {

    public InvalidNipException() {
        super("Nieprawidłowy format NIP dla faktury!");
    }
}
