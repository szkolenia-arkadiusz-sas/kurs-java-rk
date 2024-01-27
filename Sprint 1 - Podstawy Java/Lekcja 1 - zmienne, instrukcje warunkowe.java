// Pakiet -> ścieżka do pliku, w którym się znajdujemy
package org.example;

import java.util.Scanner;

// Klasa -> plik z kodem Java
public class Main {

    // Funkcja main -> funkcja, która pozwala nam uruchomić program
    public static void main(String[] args) {
        // Polecenie do wyświetlania komunikatu w konsoli
        System.out.println("Hello world!");
        System.out.println(":)");

        // 1. Typy danych (zmiennych)
        // typDanych _ nazwaZmiennej _ operatorPrzypisania _ wartość

        // int -> integer -> liczba całkowita
        // typy proste (np. int)
        int wartoscKoszykaWSklepie = 18;
        wartoscKoszykaWSklepie = wartoscKoszykaWSklepie + 15;
        System.out.println(wartoscKoszykaWSklepie);

        // String -> łańcuch -> teksty
        // typy złożone (np. String)
        // Przytrzymać Ctrl + najechać na nazwę klasy -> możemy do niej wejść
        String nazwaProduktu = "Zeszyt A4";


        // 2. Instrukcje warunkowe (IFy)
        int minimalnyWiek = 18;
        int wiekUzytkownika = 15;

        // if (warunek do sprawdzenia) {
        //      kod, który ma się wykonać
        /// }
        if (minimalnyWiek <= wiekUzytkownika) {
            System.out.println("Możesz wejśc do kasyna.");
        }
        if (minimalnyWiek > wiekUzytkownika) {
            System.out.println("Nie możesz wejść do kasyna.");
        }
    }
}
