package org.example.fakturyv2;

public class Klient
{
    String imie;
    String nazwisko;
    String adres;
    String kodKraju;


    Klient( String imie, String nazwisko, String kodKraju){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.kodKraju = kodKraju;
    }

    Klient(String imie, String nazwisko, String adres, String kodKraju) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.kodKraju = kodKraju;

    }



    public String getImie()
    {
        return imie;
    }
    public String getNazwisko()
    {
        return nazwisko;
    }
    public String getKlient(){ return imie + " " + nazwisko;}
    public String getAdres()
    {
        return adres;
    }
    public String getKodKraju()
    {
        return kodKraju;
    }

    public void setImie(String imie)
    {
        this.imie = imie;
    }
    void setNazwisko(String nazwisko)
    {
        this.nazwisko = nazwisko;
    }
    void setAdres(String adres)
    {
        this.adres = adres;
    }
    void setKodKraju(String kodKraju)
    {
        this.kodKraju = kodKraju;
    }


}
