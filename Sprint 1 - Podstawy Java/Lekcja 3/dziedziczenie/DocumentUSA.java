package org.example.dziedziczenie;

public class DocumentUSA extends Document {

    private int vatUe;

    public DocumentUSA(int number, String clientName, String vendorName, int vatUe) {
        super(number, clientName, vendorName);
        this.vatUe = vatUe;
    }

    public int getVatUe() {
        return vatUe;
    }

    public void setVatUe(int vatUe) {
        this.vatUe = vatUe;
    }
}
