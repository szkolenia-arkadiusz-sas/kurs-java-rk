package org.example.fakturyv2;

import javax.swing.*;

public class FakturaKlientZUSA extends Faktura{

    private String SSN; //Numer ubezpieczenia społecznego
    private String stanUSA; //Stan zamieszkania
    private static final double KURS_USD_PLN = 4.2 ;

    FakturaKlientZUSA(){}

    FakturaKlientZUSA(String nrFaktury, String dataWystawieniaFV, Double kwotaNettoFV, String waluta, Klient klient) {
        super(nrFaktury, dataWystawieniaFV, kwotaNettoFV, waluta, klient);

    }
    FakturaKlientZUSA(String nrFaktury, String dataWystawieniaFV, Double kwotaNettoFV, String waluta, Klient klient, String SSN, String stanUSA) {
        super(nrFaktury, dataWystawieniaFV, kwotaNettoFV, waluta, klient);
        this.SSN = SSN;
        this.stanUSA = stanUSA;
    }
    public String getSSN()
    {
        return SSN;
    }
    public String getStanUSA()
    {
        return stanUSA;
    }
    void setSSN(String SSN)
    {
        this.SSN = SSN;
    }
    void setStanUSA(String stanUSA)
    {
        this.stanUSA = stanUSA;
    }
    double przeliczeniePoKursieUSAPLN(double kwotaNettoFV)
    {
        return KURS_USD_PLN * this.kwotaNettoFV;
    }

    public double getKursUsdPln() {
        return KURS_USD_PLN;
    }
}
