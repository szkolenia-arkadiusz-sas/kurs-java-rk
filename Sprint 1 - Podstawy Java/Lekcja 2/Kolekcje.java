package org.example;

public class Kolekcje {

    // psvm - tworzenie funkcji main
    public static void main(String[] args) {

        // ----------- IF-ELSE
        int stanKonta = 1000;
        int wyplacanaKwota = 500;

        // Powstał nam jeden blok sprawdzający warunki
        if (stanKonta > wyplacanaKwota) {
            System.out.println("OK");
        }
        else if (stanKonta == wyplacanaKwota) {
            System.out.println("OK, ale promocja się kasuje");
        }
        else {
            System.out.println("NIE OK");
        }

        // ----------- TABLICE I PĘTLE
        double liczba1 = 7.5;
        double liczba2 = 8.31;

        // Jak stworzyć tablicę?
        double[] liczby = new double[10];
        double[] liczby2 = new double[]{2.2, 3, 9.9};

        // Jak wyświetlić jeden element?
        System.out.println(liczby2[0]);
        System.out.println(liczby2[2]);

        // Jak wyświetlic wszystkie elementy?
        // Pętle przydają się, kiedy chcemy wykonać wielkrotnie taki sam kod
        // For -> sprawdza się najlepiej, kiedy wiemy ile razy chcemy wywołać kod
        for (int i = 0; i <= 2; i++) {
            System.out.println(liczby2[i]);
        }

        // While -> sprawdza się najlepiej, kiedy nie wiem jak długo warunek będzie spełniony
        int i = 0;
        while (i <= 2) {
            System.out.println(liczby2[i]);
            i++;
        }
    }
}
