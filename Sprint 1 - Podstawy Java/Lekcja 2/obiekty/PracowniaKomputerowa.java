package org.example.obiekty;

public class PracowniaKomputerowa {

    public static void main(String[] args) {

        // 1. Stworzenie nowej instancji typu Komputer
        Komputer komputer1 = new Komputer();
        Komputer komputer2 = new Komputer("AMD", 64);

        System.out.println(komputer1.getRam());
        System.out.println(komputer2.getRam());
        komputer1.setRam(64);
        System.out.println(komputer1.getRam());
        System.out.println(komputer2.getRam());

    }
}
