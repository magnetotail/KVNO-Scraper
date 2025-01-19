package de.foospace.two.domain.singlePerson;

import java.util.stream.Stream;

public class Termin {
    private int tag;
    private Zeitraum[] hours;

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public Zeitraum[] getHours() {
        return hours;
    }

    public void setHours(Zeitraum[] hours) {
        this.hours = hours;
    }

    public String toCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append(getWochentag());
        for (Zeitraum hour : hours) {
            sb.append(hour.getTermineVon());
            sb.append(" - ");
            sb.append(hour.getTermineBis());
            sb.append(",");
        }
        return sb.toString();
    }

    private String getWochentag(){
        switch (tag){
            case(0): return "Mo: ";
            case(1): return "Di: ";
            case(2): return "Mi: ";
            case(3): return "Do: ";
            case(4): return "Fr: ";
            case(5): return "Sa: ";
            case(6): return "So: ";
            default: throw new IllegalArgumentException("Unbekannter Tag: " + tag);
        }
    }
}
