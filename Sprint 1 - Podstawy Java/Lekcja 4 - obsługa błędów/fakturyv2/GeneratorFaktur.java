package org.example.fakturyv2;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.IllformedLocaleException;
import java.util.List;
import java.util.Scanner;

public class GeneratorFaktur {

    private Scanner scannerFaktura = new Scanner(System.in);
    private ArrayList<Faktura> listaFaktur = new ArrayList<>();

    private static final int MAKSYMALNA_LICZBA_FAKTUR = 2;

    public ArrayList<Faktura> pobierzFaktury() {

        for (int i = 0; i < MAKSYMALNA_LICZBA_FAKTUR; i++) {

            String nrFaktury = pobierzNrFaktury();
            String dataWystawieniaFV = pobierzDateWystawieniaFV();
            double kwotaNettoFV = pobierzKwoteNettoFV();
            String waluta = pobierzWalute();
            String imie = pobierzImieKlienta();
            String nazwisko = pobierzNazwiskoKlienta();
            String kodKraju = pobierzKodKraju();

            listaFaktur.add(utworzFakture(nrFaktury, dataWystawieniaFV, kwotaNettoFV, waluta, imie, nazwisko, kodKraju));
        }
        return listaFaktur;
    }
    public ArrayList<Faktura> getListaFaktur()
    {
        return listaFaktur;
    }



    private String pobierzNrFaktury() {
        System.out.println("Podaj numer faktury: ");
        return scannerFaktura.next();
    }

    private String pobierzDateWystawieniaFV() {
        System.out.println("Podaj datę facture w formacie yyyy-MM-dd: ");
        return scannerFaktura.next();
    }

    private double pobierzKwoteNettoFV() {
        System.out.println("Podaj kwotę netto faktury:");
        return scannerFaktura.nextDouble();
    }
    private String pobierzWalute()
    {
        System.out.println("Podaj Walutę: ");
        System.out.println("Wpisz jedną z : PLN, EUR, USD: ");
        return scannerFaktura.next();
    }
    private String pobierzImieKlienta() {
        System.out.println("Podaj imie klienta: ");
        return scannerFaktura.next();
    }

    private String pobierzNazwiskoKlienta() {
        System.out.println("Podaj nazwika klienta: ");
        return scannerFaktura.next();
    }

    private String pobierzKodKraju() {
        System.out.println("Podaj kod Kraju:");
        System.out.println("(PL) Polska; (DE) Niemncy; (US) USA");

        String countryCode = scannerFaktura.next();
        try {
            validateCountryCode(countryCode);
        } catch (Exception e) { // Obsługa dowolnego wyjątku
            System.out.println("Obsługa..");
        }
        // zazwyczaj jest po prostu tak:
        validateCountryCode(countryCode);

        return countryCode;
    }

    private void validateCountryCode(String coutnryCode) {
        if ("".equals(coutnryCode)) {
            throw new EmptyCoutnryCodeException("Empty country code!");
        }
    }

    private String pobierzNIP() {
        System.out.println("Podaj NIP: ");
        return scannerFaktura.next();
    }

    private String pobierzUStIdNr() {
        System.out.println("Podaj UStIdNr (Numer identyfikacyjny podatku VAT): ");
        return scannerFaktura.next();
    }

    private String pobierzSSN() {
        System.out.println("Podaj SSN (Numer ubezpieczenia społecznego): ");
        return scannerFaktura.next();
    }

    private String pobierzStanUSA() {
        System.out.println("Podaj Stan USA: ");
        return scannerFaktura.next();
    }

    private Faktura utworzFakture(String nrFaktury, String dataWystawieniaFV, Double kwotaNettoFV, String waluta, String imie, String nazwisko, String kodKraju) {
        Klient klient = new Klient(imie, nazwisko, kodKraju);
        if ("PL".equals(kodKraju) || "pl".equals(kodKraju)) {
            String nip = pobierzNIP();
            return utworzFaktureDlaKlientaZPolski(nrFaktury, dataWystawieniaFV, kwotaNettoFV, waluta,  klient, nip);
        } else if ("DE".equals(kodKraju) || "de".equals(kodKraju)) {
            String UStIdNr = pobierzUStIdNr();
            return utworzFaktureDlaKlientaZNiemiec(nrFaktury, dataWystawieniaFV, kwotaNettoFV, waluta,  klient, UStIdNr);
        } else if ("US".equals(kodKraju) || "us".equals(kodKraju)) {
            String SSN = pobierzSSN();
            String stanUSA = pobierzStanUSA();
            return utworzFaktureDlaKlientaZUSA(nrFaktury, dataWystawieniaFV, kwotaNettoFV, waluta, klient, SSN, stanUSA);
        }
        throw new IllformedLocaleException("NIeprawidłowy Kod Kraju");
    }

    private FakturaKlientZPolski utworzFaktureDlaKlientaZPolski(String nrFaktury, String dataWystawieniaFV, Double kwotaNettoFV, String waluta, Klient klient, String nip)
    {
        return new FakturaKlientZPolski(nrFaktury, dataWystawieniaFV, kwotaNettoFV, waluta, klient, nip);
    }
    private FakturaKlientZNIemiec utworzFaktureDlaKlientaZNiemiec(String nrFaktury, String dataWystawieniaFV, Double kwotaNettoFV, String waluta, Klient klient, String UStIdNr)
    {

        return new FakturaKlientZNIemiec(nrFaktury, dataWystawieniaFV, kwotaNettoFV, waluta, klient, UStIdNr);
    }
    private FakturaKlientZUSA utworzFaktureDlaKlientaZUSA(String nrFaktury, String dataWystawieniaFV, Double kwotaNettoFV, String waluta, Klient klient, String SSN, String stanUSA)
    {
        return new FakturaKlientZUSA(nrFaktury, dataWystawieniaFV, kwotaNettoFV, waluta, klient, SSN, stanUSA);
    }

}
