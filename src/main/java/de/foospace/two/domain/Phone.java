package de.foospace.two.domain;

public class Phone {

    private String telefonvorwahl;
    private String telefonnummer;

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getTelefonvorwahl() {
        return telefonvorwahl;
    }

    public void setTelefonvorwahl(String telefonvorwahl) {
        this.telefonvorwahl = telefonvorwahl;
    }

    @Override
    public String toString() {
        return telefonvorwahl + "/" + telefonnummer;
    }
}
