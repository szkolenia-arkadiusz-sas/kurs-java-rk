package org.example.obslugabledow;

import org.example.fakturyv2.FakturaKlientZNIemiec;
import org.example.fakturyv2.InvalidCurrencyRateException;

public class Main {

    public static void main(String[] args) {

        // EXCEPTION - ERROR

        // CHECKED (extends Exception) - UNCHECKED (extends RuntimeException)
        // Checked -> wyjątki dziedziącze po klasie Exception (muszą być obsłużone)
        // 1. Dodanie do nagłówka metody słowa throws + nazwa wyjątku, którgo się spodziewamy
        // 2. Stosowanie bloku try-catch -> pozwala obsłużyć błąd i program żyje dalej
        /*File file = new File("not_existing_file.txt");

        try {
            FileInputStream stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println(e); // Informacja, ale możemy kontyunować pracę
            //throw new InvalidNipException(); // Musimy zakończyć obsługę żądania, bo jest błąd, z którym nie możemy iść dalej
        } catch (InvalidNipException e) {

        } finally {
            System.out.println("JESTEM ZAWSZE");
        }
        System.out.println(5);*/

        FakturaKlientZNIemiec fakturaKlientZNIemiec = new FakturaKlientZNIemiec("1", "1", 10.0, "EUR", null);
        try {
            System.out.println(fakturaKlientZNIemiec.przeliczeniePoKursieEURPLN());
        } catch (InvalidCurrencyRateException e) {
            System.out.println("Nie udało się pobrać prawidłowego kursu walut! Spróbuj ponownie");
        }
        System.out.println(fakturaKlientZNIemiec.przeliczeniePoKursieEURPLN());

    }
}
