package org.example.obiekty;

// public, protected, _ (package private)
class Komputer {

    // 1. Właściwości obiektu (zmienne), w 99% przypadków powinny być one prywatne
    private String nazwaProcesora;
    private int ram;
    // Jeżeli chcemy inną wartość domyślną:
    // private int ram = 16;
    private String[] nazwaUzytkownika;

    // 2. Tworzenie obiektu z NIEZBĘDNYMI WŁAŚCIWOŚCIAMI -> KONSTRUKTOR
    public Komputer(String nazwaProcesora, int ram) {
        this.nazwaProcesora = nazwaProcesora;
        this.ram = ram;
    }

    public Komputer() {

    }

    // 3. Metody obiektu
    // FUNKCJE -> blok kodu realizujące zadanie

    // GETTER -> metody pozwalające na odczyt właściwości
    public int getRam() {
        return ram;
    }

    // SETTER -> metody pozwalające na ustawieanie wartości właściwości
    public void setRam(int ram) {
        this.ram = ram;
    }

}
