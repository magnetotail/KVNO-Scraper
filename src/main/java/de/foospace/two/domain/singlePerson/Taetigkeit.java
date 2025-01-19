package de.foospace.two.domain.singlePerson;

public class Taetigkeit {

    private int taetigkeitTyp;
    private TaetigkeitAnLeistungsort[] taetigkeitAnLeistungsorten;

    public int getTaetigkeitTyp() {
        return taetigkeitTyp;
    }

    public void setTaetigkeitTyp(int taetigkeitTyp) {
        this.taetigkeitTyp = taetigkeitTyp;
    }

    public TaetigkeitAnLeistungsort[] getTaetigkeitAnLeistungsorten() {
        return taetigkeitAnLeistungsorten;
    }

    public String toCSV() {
        return taetigkeitAnLeistungsorten[0].toCSV();
    }
}
