package org.example.fakturyv2;

import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.sql.SQLTimeoutException;
import java.util.ArrayList;
import java.util.Scanner;

public class Raporty {

    Wydruk wydruk = new Wydruk();

    public void listaFakturdlaKlientówZPolski(ArrayList<Faktura> listaFaktur)
    {
        for(Faktura obiektFV: listaFaktur)
        {
            if(obiektFV instanceof FakturaKlientZPolski)
            {
                WydrukUtils.wydrukujInformacjeWspolneDlaFaktur(obiektFV);
                System.out.println("Kwota netto faktury: " + wydruk.formatKwotyIWaluty(obiektFV.getKwotaNettoFV(), obiektFV.getWaluta()));
                System.out.println("NIP: " + ((FakturaKlientZPolski) obiektFV).getNIP());
                System.out.println("------------------------------------");

            }
        }
        System.out.println("------------------------------------");
        System.out.println("Suma kwot dla faktur z Polski " + sumaKwotPL(listaFaktur));
        System.out.println("------------------------------------");
        System.out.println();
    }
    public void listaFakturdlaKlientówZNIemiec(ArrayList<Faktura> listaFaktur) {
        for(Faktura obiektFV: listaFaktur)
        {
            if(obiektFV instanceof FakturaKlientZNIemiec)
            {
                WydrukUtils.wydrukujInformacjeWspolneDlaFaktur(obiektFV);
                // Metoda niestatyczna z klasy -> lepsze w tym przypadku
                System.out.println("Kwota netto faktury: " + ((FakturaKlientZNIemiec) obiektFV).przeliczeniePoKursieEURPLN());
                // Metoda statyczna z klasy
                System.out.println("Kwota netto faktury: " + FakturaKlientZNIemiec.przeliczeniePoKursieEURPLN(obiektFV.getKwotaNettoFV()));
                StringUtils.EMPTY.equals(obiektFV.getNrFaktury());
                "".equals(obiektFV.getNrFaktury());
                System.out.println("Numer identyfikacyjny podatku VAT (USt-IdNr): " + ((FakturaKlientZNIemiec) obiektFV).getUStIdNr());
                System.out.println("------------------------------------");

            }
        }
        System.out.println("------------------------------------");
        System.out.println("Suma kwot dla faktur z Niemiec " + sumaKwotDE(listaFaktur));
        System.out.println("------------------------------------");
        System.out.println();
    }
    public void listaFakturdlaKlientówZUSA(ArrayList<Faktura> listaFaktur)
    {
        for(Faktura obiektFV: listaFaktur)
        {
            if(obiektFV instanceof FakturaKlientZUSA)
            {
                WydrukUtils.wydrukujInformacjeWspolneDlaFaktur(obiektFV);
                System.out.println("Numer ubezpieczenia społecznego (SSN): " + ((FakturaKlientZUSA) obiektFV).getSSN());
                System.out.println("Stan zamieszkania: " + ((FakturaKlientZUSA) obiektFV).getStanUSA());
                System.out.println("------------------------------------");

            }
        }
        System.out.println("------------------------------------");
        System.out.println("Suma kwot dla faktur z USA " + sumaKwotUSA(listaFaktur));
        System.out.println("------------------------------------");
        System.out.println();
    }

    private String sumaKwotPL(ArrayList<Faktura> listaFaktur)
    {
        double sumaPL = 0;
        for(Faktura obiektDE: listaFaktur)
        {
            if(obiektDE instanceof FakturaKlientZPolski)
            {
                sumaPL += obiektDE.getKwotaNettoFV();
            }
        }
        return String.format("%.2f", sumaPL) + " PLN";
    }
    private String sumaKwotDE(ArrayList<Faktura> listaFaktur)
    {
        double sumaDE = 0;
        for(Faktura obiektDE: listaFaktur)
        {
            if(obiektDE instanceof FakturaKlientZNIemiec)
            {
                sumaDE += obiektDE.getKwotaNettoFV();
            }
        }
        return String.format("%.2f", sumaDE) + " EUR";
    }
    private String sumaKwotUSA(ArrayList<Faktura> listaFaktur)
    {
        double sumaUSA = 0;
        for(Faktura obiektUSA: listaFaktur)
        {
            if(obiektUSA instanceof FakturaKlientZUSA)
            {
                sumaUSA += obiektUSA.getKwotaNettoFV();
            }
        }
        return String.format("%.2f", sumaUSA) + " USD";
    }

    protected String listaFVDanegoKlientaDE(ArrayList<Faktura> listaFaktur)
    {
        Scanner scannerKlientDE = new Scanner(System.in);
        System.out.println("Podaj Numer identyfikacyjny podatku VAT (USt-IdNr) KLienta dla którego chcesz wyświelić FV:");
        String UStIdNr_DlaKlientaZNiemiec = scannerKlientDE.next();
        System.out.println("Faktury dla Klienta z Niemiec o Numer identyfikacyjny podatku VAT (USt-IdNr): " + UStIdNr_DlaKlientaZNiemiec);

        for(Faktura obiektDE: listaFaktur)
        {
            if(obiektDE instanceof FakturaKlientZNIemiec && (UStIdNr_DlaKlientaZNiemiec).equals(((FakturaKlientZNIemiec)obiektDE).getUStIdNr()))
            {
                System.out.println("------------------------------------");
                System.out.println("Numer faktury: " + obiektDE.getNrFaktury());
                System.out.println("Data faktury: " + obiektDE.getDataWystawieniaFV());
                System.out.println("Klient: " + obiektDE.klient.getKlient() + "  (" + obiektDE.klient.getKodKraju() + ")");
                System.out.println("Kwota netto faktury: " + wydruk.formatKwotyIWaluty(obiektDE.getKwotaNettoFV(), obiektDE.getWaluta()));
                System.out.println("Numer identyfikacyjny podatku VAT (USt-IdNr): " + ((FakturaKlientZNIemiec) obiektDE).getUStIdNr());
                System.out.println("------------------------------------");
            }
        }
        return "";
    }

}
