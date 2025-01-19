package de.foospace.two.domain.singlePerson;

import java.util.Arrays;
import java.util.Comparator;

public class Sprechzeit {
    private int sprechzeitArt; //1 = Sprechzeiten in Praxis. 2 = Telefonsprechzeiten. 3 = sonstige Sprechzeit in Praxis oder so??
    private String vereinbarung1;

    public int getSprechzeitArt() {
        return sprechzeitArt;
    }

    public void setSprechzeitArt(int sprechzeitArt) {
        this.sprechzeitArt = sprechzeitArt;
    }

    public String getVereinbarung1() {
        return vereinbarung1;
    }

    public void setVereinbarung1(String vereinbarung1) {
        this.vereinbarung1 = vereinbarung1;
    }

    public Termin[] getTermine() {
        return termine;
    }

    public void setTermine(Termin[] termine) {
        this.termine = termine;
    }

    private Termin[] termine;

    public String toCSV(){
        Arrays.sort(termine, Comparator.comparing(Termin::getTag));

        StringBuilder sb = new StringBuilder();
        for (Termin termin : termine) {
            sb.append(termin.toCSV());
        }
        sb.append(";");
        return sb.toString();
    }
}
