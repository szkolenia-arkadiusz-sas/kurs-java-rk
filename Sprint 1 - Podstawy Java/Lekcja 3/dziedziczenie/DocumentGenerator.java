package org.example.dziedziczenie;

import java.util.Objects;

public class DocumentGenerator {

    // psvm
    public static void main(String[] args) {

        // Document jeśli chcemy korzystać tylko ze wspólnych cech i metod,
        // a DocumentKonkretnyKlient jeśli chcemy korzystać też ze specyficznych właściwości
        DocumentDE documentDE = new DocumentDE(1, "AClient", "BVendor", "PL");
        DocumentUSA documentUSA = new DocumentUSA(1, "AClient", "BVendor", 3);
        getPrice(documentDE);
        getPrice(documentUSA);

        // Nie możemy utworzyć, bo Docuemnt jest abstract
        // Document document = new Document(1, "A", "B");

        // SOLID -> Liskov substiution -> w tym momencie nie spełniamy

        // DocumentDE documentDEAfterCasting = (DocumentDE) documentDE;
        // Rzutowanie -> (klasaDocelowa) zmienna
        if (documentDE.getCountry() != null) {
            System.out.println(documentDE.getCountry().contains("UK"));
        }
        // Taki sam efekt
        if (Objects.nonNull(documentDE.getCountry())) {
            System.out.println(documentDE.getCountry().contains("PL"));
        }
        // Optional -> Java 8+
        System.out.println("");

        // Mamy dostęp, bo metoda jest protected, a nie private
        documentDE.concatClientNameAndVendorName();

        // -------------------------------------------------------------------------------
        Document document;
        document = new DocumentDE(1, "AClient", "BVendor", "PL");
        document = new DocumentUSA(1, "AClient", "BVendor", 3);
    }

    private static double getPrice(Document document) {
        return document.getNumber() * 1.23;
    }

    // Nie potrzebujemy tego dzięki poliforizmowi:
    /*
    private static double getPrice(DocumentDE document) {
        return document.getNumber() * 1.23;
    }

    private static double getPrice(DocumentUSA document) {
        return document.getNumber() * 1.23;
    }
     */

}
