package org.example.dziedziczenie;

import java.util.Objects;

public abstract class Document {

    private int number;
    private String clientName;
    private String vendorName;

    // ALT + INSERT
    public Document(int number, String clientName, String vendorName) {
        this.number = number;
        this.clientName = clientName;
        this.vendorName = vendorName;
    }

    protected String concatClientNameAndVendorName() {
        return this.clientName + ":" + this.vendorName;
    }

    public int getNumber() {
        return number;
    }

    public String getClientName() {
        return clientName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return number == document.number && Objects.equals(clientName, document.clientName) && Objects.equals(vendorName, document.vendorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, clientName, vendorName);
    }
}
