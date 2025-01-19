package de.foospace.two.domain.singlePerson;

import de.foospace.two.domain.Email;
import de.foospace.two.domain.Homepage;
import de.foospace.two.domain.Phone;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class TaetigkeitAnLeistungsort {

    private String plz;
    private String ort;
    private Sprechzeit[] sprechzeiten;

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

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public Phone[] getTelefon() {
        return telefon;
    }

    public void setTelefon(Phone[] telefon) {
        this.telefon = telefon;
    }

    public Homepage[] getHomepage() {
        return homepage;
    }

    public void setHomepage(Homepage[] homepage) {
        this.homepage = homepage;
    }

    public Email[] getEmail() {
        return email;
    }

    public void setEmail(Email[] email) {
        this.email = email;
    }

    private String strasse;
    private String hausnummer;
    private Phone[] telefon;
    private Homepage[] homepage;
    private Email[] email;

    public String toCSV() {
//        System.out.println(homepage.length);
        StringBuilder sb = new StringBuilder();
        sb.append(plz).append(" ");
        sb.append(ort).append(";");
        sb.append(strasse).append(" ");
        sb.append(hausnummer).append(";");
        sb.append(telefon != null && telefon.length > 0 ? telefon[0].toString() : "").append(";");
        sb.append(test()).append(";");
        sb.append(homepage != null && homepage.length > 0 ? homepage[0].toString() : "").append(";");
        sb.append(createSprechzeiten());

        return sb.toString();
    }

    private String test() {
        return email != null && email.length > 0 ? email[0].toString() : "";
    }

    private String createSprechzeiten() {
        StringBuilder builder = new StringBuilder();
        Arrays.sort(sprechzeiten, Comparator.comparing(Sprechzeit::getSprechzeitArt));
        if (sprechzeiten.length == 0) {
            builder.append("nicht vorhanden;nicht vorhanden;");
            return builder.toString();
        }
        Sprechzeit praxissprechzeit = Stream.of(sprechzeiten).filter(s -> s.getSprechzeitArt() == 1).findAny().orElse(null);
        builder.append(praxissprechzeit != null ? praxissprechzeit.toCSV() : "keine Praxissprechzeit;");
        Sprechzeit telefonSprechzeit = Stream.of(sprechzeiten).filter(s -> s.getSprechzeitArt() == 2).findAny().orElse(null);
        builder.append(telefonSprechzeit != null ? telefonSprechzeit.toCSV() : "keine telefonsprechzeit;");
        return builder.toString();
    }
}
