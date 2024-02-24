package org.example.fakturyv2;

public class FakturaKlientZNIemiec extends Faktura {

    private String UStIdNr; // Numer identyfikacyjny podatku VAT
    FakturaKlientZNIemiec(){}
    public FakturaKlientZNIemiec(String nrFaktury, String dataWystawieniaFV, Double kwotaNettoFV, String waluta, Klient klient) {
        super(nrFaktury, dataWystawieniaFV, kwotaNettoFV, waluta, klient);

    }
    FakturaKlientZNIemiec(String nrFaktury, String dataWystawieniaFV, Double kwotaNettoFV, String waluta, Klient klient, String UStIdNr) {
        super(nrFaktury, dataWystawieniaFV, kwotaNettoFV, waluta, klient);
        this.UStIdNr = UStIdNr;
    }

    public String getUStIdNr()
    {
        return UStIdNr;
    }
    void setUStIdNr(String UStIdNr)
    {
        this.UStIdNr = UStIdNr;
    }
    public double przeliczeniePoKursieEURPLN() {
        if (KURS_EUR_PLN < 0) {
            throw new InvalidCurrencyRateException(KURS_EUR_PLN);
        }
        return KURS_EUR_PLN * this.kwotaNettoFV;
    }
}
