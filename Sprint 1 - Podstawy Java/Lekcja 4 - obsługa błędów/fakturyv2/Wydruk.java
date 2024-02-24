package org.example.fakturyv2;


import java.util.ArrayList;

public class Wydruk {
    FakturaKlientZNIemiec pobranieKursuEURPLN  = new FakturaKlientZNIemiec();
    FakturaKlientZUSA pobranieKursuUSDPLN  = new FakturaKlientZUSA();
    double kursUsdPln =   pobranieKursuUSDPLN.getKursUsdPln();
    public void wydrukFaktur(ArrayList<Faktura> listaFaktur)
    {
        System.out.println("Dane faktur:");
        //for (int i = 0 ; i < 2; i++)
        for(Faktura obiektFV: listaFaktur)

        {

            //Faktura obiektFV = listaFaktur.get(i);

            System.out.println("------------------------------------");
            System.out.println("Numer faktury: " + obiektFV.getNrFaktury());
            System.out.println("Data faktury: " + obiektFV.getDataWystawieniaFV());
            System.out.println("Klient: " + obiektFV.klient.getKlient() + "  (" + obiektFV.klient.getKodKraju() + ")");
            System.out.println("Kwota netto faktury: " + formatKwotyIWaluty(obiektFV.getKwotaNettoFV(), obiektFV.getWaluta()));
            wyborRodzajuFV(obiektFV);
           /* if (obiektFV instanceof FakturaKlientZPolski)
                System.out.println("NIP: " + ((FakturaKlientZPolski) obiektFV).getNIP());
            else if (obiektFV instanceof FakturaKlientZNIemiec)
                System.out.println("Numer identyfikacyjny podatku VAT (USt-IdNr): " + ((FakturaKlientZNIemiec) obiektFV).getUStIdNr());
            else if (obiektFV instanceof FakturaKlientZUSA)
            {
                System.out.println("Numer ubezpieczenia społecznego (SSN): " + ((FakturaKlientZUSA) obiektFV).getSSN());
                System.out.println("Stan zamieszkania: " + ((FakturaKlientZUSA) obiektFV).getStanUSA());
            }*/
           System.out.println("------------------------------------");
            System.out.println();
        }
        System.out.println("Podsumowanie:");
        System.out.println("Łączna kwota faktur (PLN):" + podsumowaniePLN(listaFaktur));
        System.out.println("Łączna kwota faktur (EUR):" + podsumowanieEUR(listaFaktur));
        System.out.println("Łączna kwota faktur (USD):" + podsumowanieUSD(listaFaktur));

    }


    private String wyborRodzajuFV(Faktura obiektFV)
    {
        if (obiektFV instanceof FakturaKlientZPolski)
            return "NIP: " + ((FakturaKlientZPolski) obiektFV).getNIP();
        else if (obiektFV instanceof FakturaKlientZNIemiec)
            return "Numer identyfikacyjny podatku VAT (USt-IdNr): " + ((FakturaKlientZNIemiec) obiektFV).getUStIdNr();
        else if (obiektFV instanceof FakturaKlientZUSA)
            return
            "Numer ubezpieczenia społecznego (SSN): " + ((FakturaKlientZUSA) obiektFV).getSSN() + "\n" +
                    "Stan zamieszkania: " + ((FakturaKlientZUSA) obiektFV).getStanUSA();

        return "";
    }






    protected String formatKwotyIWaluty(double kwotaNetto, String waluta)
    {
        if(("PLN").equals(waluta) || ("pln").equals(waluta)) {
            return String.format("%.2f PLN", kwotaNetto);
        } else if (("EUR").equals(waluta) || ("eur").equals(waluta)) {
            return String.format("%.2f EUR", kwotaNetto);
        } else if (("USD").equals(waluta) || ("usd").equals(waluta)) {
            return String.format("%.2f USD", waluta);
        }
        return "";

    }

    private String podsumowaniePLN(ArrayList<Faktura> listaFaktur)
    {
        double sumaPLN = 0;
        for(Faktura obiektPodsumownie: listaFaktur)
        {
            if(("PLN").equals(obiektPodsumownie.getWaluta())) {
                sumaPLN += obiektPodsumownie.getKwotaNettoFV();
            }
        }
        return String.format("%.2f", sumaPLN) + " PLN";
                //String.format("%.2f", sumaPLN) + "\n" + String.format("%.2f", sumaEUR);
    }
    private String podsumowanieEUR(ArrayList<Faktura> listaFaktur)
    {

        double sumaEUR = 0;
        double sumaEURprzeliczonaNaPLN = 0;
        for(Faktura obiektPodsumownieEUR: listaFaktur)
        {
            if(("EUR").equals(obiektPodsumownieEUR.getWaluta()) || ("eur").equals(obiektPodsumownieEUR.getWaluta()))
            {
                //sumaEUR += obiektPodsumownieEUR.getKwotaNettoFV();
                sumaEURprzeliczonaNaPLN += Faktura.przeliczeniePoKursieEURPLN(obiektPodsumownieEUR.getKwotaNettoFV());
            }
            //sumaEURprzeliczonaNaPLN = kursEurPln * sumaEUR;
        }

        return String.format("%.2f", sumaEUR) + " EUR :  " + String.format("%.2f",sumaEURprzeliczonaNaPLN)  + " PLN";
    }
    private String podsumowanieUSD(ArrayList<Faktura> listaFaktur)
    {
        double sumaUSD = 0;
        double sumaUSDprzeliczonaNaPLN = 0;

        for(Faktura obiektPodsumownieUSD: listaFaktur)
        {
            if(("USD").equals(obiektPodsumownieUSD.getWaluta()) ||("usd").equals(obiektPodsumownieUSD.getWaluta()))
            {
                sumaUSD += obiektPodsumownieUSD.getKwotaNettoFV();
            }
            sumaUSDprzeliczonaNaPLN = kursUsdPln * sumaUSD;
        }
        return String.format("%.2f", sumaUSD) + " USD :  " + String.format("%.2f",sumaUSDprzeliczonaNaPLN)  + " PLN";
    }
}
