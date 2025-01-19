package de.foospace.two.domain.singlePerson;

public class SinglePerson {
    private long personId;
    private int geschlecht;

    public int getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(int geschlecht) {
        this.geschlecht = geschlecht;
    }

    private String vortitel;
    private String vorname;
    private String zwischentitel;
    private String nachname;
    private boolean isPrivatarzt;

    private Titel[] akademischerTitel;

    public Titel[] getAkademischerTitel() {
        return akademischerTitel;
    }

    public void setAkademischerTitel(Titel[] akademischerTitel) {
        this.akademischerTitel = akademischerTitel;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getVortitel() {
        return vortitel;
    }

    public void setVortitel(String vortitel) {
        this.vortitel = vortitel;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getZwischentitel() {
        return zwischentitel;
    }

    public void setZwischentitel(String zwischentitel) {
        this.zwischentitel = zwischentitel;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public boolean isPrivatarzt() {
        return isPrivatarzt;
    }

    public void setPrivatarzt(boolean privatarzt) {
        isPrivatarzt = privatarzt;
    }

    public Taetigkeit[] getTaetigkeiten() {
        return taetigkeiten;
    }

    public void setTaetigkeiten(Taetigkeit[] taetigkeiten) {
        this.taetigkeiten = taetigkeiten;
    }

    private Taetigkeit[] taetigkeiten;

    public String toCSV() {
        return
                new StringBuilder()
                        .append(getGeschlechtString()).append(";")
                        .append(akademischerTitel.length > 0 ? akademischerTitel[0].getTitelOrg() : "").append(";")
                        .append(vorname).append(";")
                        .append(nachname).append(";")
                        .append(isPrivatarzt ? "ja;" : "nein;")
                        .append(taetigkeiten[0].toCSV())
                        .append("\n")
                        .toString();

    }

    private String getGeschlechtString(){
        switch(geschlecht) {
            case 1: return "Frau";
            case 2: return "Herr";
            default: return "unbekannt";
        }
    }
}
