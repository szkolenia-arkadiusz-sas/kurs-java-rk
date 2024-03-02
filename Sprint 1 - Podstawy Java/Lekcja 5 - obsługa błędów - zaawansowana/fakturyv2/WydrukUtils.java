package org.example.fakturyv2;

public class WydrukUtils {

    public static void wydrukujInformacjeWspolneDlaFaktur(Faktura faktura) {
        System.out.println("------------------------------------");
        System.out.println("Faktury dla Klientów z USA");
        System.out.println("------------------------------------");
        System.out.println("Numer faktury: " + faktura.getNrFaktury());
        System.out.println("Data faktury: " + faktura.getDataWystawieniaFV());
        System.out.println("Klient: " + faktura.klient.getKlient() + "  (" + faktura.klient.getKodKraju() + ")");
    }
}
