package org.example.dziedziczenie;

public class DocumentDE extends Document {
    private String country;

    public DocumentDE(int number, String clientName, String vendorName, String country) {
        super(number, clientName, vendorName);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
