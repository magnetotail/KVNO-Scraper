package de.foospace.two.domain;

public class Person {

    private String title;
    private String strasse;
    private String plz;
    private String ort;
    private Phone[] telefon;
    private Homepage[] homePage;
    private Email[] email;
    private String geschlectTitle;
    private String vorname;
    private String nachname;
    private long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Phone[] getTelefon() {
        return telefon;
    }

    public void setTelefon(Phone[] telefon) {
        this.telefon = telefon;
    }

    public Homepage[] getHomePage() {
        return homePage;
    }

    public void setHomePage(Homepage[] homePage) {
        this.homePage = homePage;
    }

    public Email[] getEmail() {
        return email;
    }

    public void setEmail(Email[] email) {
        this.email = email;
    }

    public String getGeschlectTitle() {
        return geschlectTitle;
    }

    public void setGeschlectTitle(String geschlectTitle) {
        this.geschlectTitle = geschlectTitle;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
