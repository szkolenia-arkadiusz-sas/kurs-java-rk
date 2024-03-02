package org.example.fakturyv2;

public class Ksiegowy {
    public static void main(String[] args) throws InvalidCurrencyRateException {

        GeneratorFaktur generatorFaktur = new GeneratorFaktur();
        generatorFaktur.pobierzFaktury();
        Wydruk wydruk = new Wydruk();
        Raporty raporty = new Raporty();

        wydruk.wydrukFaktur(generatorFaktur.pobierzFaktury());
        raporty.listaFakturdlaKlientówZPolski(generatorFaktur.getListaFaktur());
        System.out.println();
        raporty.listaFakturdlaKlientówZNIemiec(generatorFaktur.getListaFaktur());
        System.out.println();
        raporty.listaFakturdlaKlientówZUSA(generatorFaktur.getListaFaktur());
        System.out.println("-------------------------------------------");
        raporty.listaFVDanegoKlientaDE(generatorFaktur.getListaFaktur());
    }

}
