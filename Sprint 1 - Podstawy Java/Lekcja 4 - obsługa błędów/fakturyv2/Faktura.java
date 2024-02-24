package org.example.fakturyv2;

public abstract class Faktura {

    protected static final double KURS_EUR_PLN = -5; //Kurs EUR/PLN

    String nrFaktury;
    String dataWystawieniaFV;
    double kwotaNettoFV;
    String waluta;
    Klient klient;
    public Faktura() {
    }
    Faktura(String nrFaktury, String dataWystawieniaFV, Double kwotaNettoFV, String waluta, Klient klient)
    {
        this.nrFaktury = nrFaktury;
        this.dataWystawieniaFV = dataWystawieniaFV;
        this.kwotaNettoFV = kwotaNettoFV;
        this.waluta = waluta;
        this.klient = klient;

    }

    protected static double przeliczeniePoKursieEURPLN(double kwotaNettoFV) {
        return KURS_EUR_PLN * kwotaNettoFV;
    }

    String getNrFaktury()
    {
        return this.nrFaktury;
    }
    String getDataWystawieniaFV()
    {
        return this.dataWystawieniaFV;
    }
    double getKwotaNettoFV()
    {
        return this.kwotaNettoFV;
    }

    String getWaluta(){return  this.waluta;}

    void setNrFaktury(String nrFaktury)
    {
        this.nrFaktury = nrFaktury;
    }
    void setDataWystawieniaFV(String dataWystawieniaFV)
    {
        this.dataWystawieniaFV = dataWystawieniaFV;
    }
    void setKwotaNettoFV(double kwotaNettoFV)
    {
        this.kwotaNettoFV = kwotaNettoFV;
    }
    void setWaluta(String waluta){ this.waluta = waluta;}

}