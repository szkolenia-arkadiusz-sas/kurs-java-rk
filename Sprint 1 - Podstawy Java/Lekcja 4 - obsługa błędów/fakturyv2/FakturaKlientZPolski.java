package org.example.fakturyv2;

public class FakturaKlientZPolski extends Faktura {

    String NIP; // Numer Identyfikacji Podatkowej
    FakturaKlientZPolski(String nrFaktury, String dataWystawieniaFV, Double kwotaNettoFV, String waluta, Klient klient) {
        super(nrFaktury, dataWystawieniaFV, kwotaNettoFV, waluta, klient);
        //this.NIP = NIP;
    }
    FakturaKlientZPolski(String nrFaktury, String dataWystawieniaFV, Double kwotaNettoFV, String waluta, Klient klient, String NIP) {
        super(nrFaktury, dataWystawieniaFV, kwotaNettoFV, waluta, klient);
        this.NIP = NIP;
    }

    public String getNIP()
    {
        return NIP;
    }
    void setNIP(String NIP)
    {
        this.NIP = NIP;
    }


}
