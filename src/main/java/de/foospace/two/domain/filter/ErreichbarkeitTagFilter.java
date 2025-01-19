package de.foospace.two.domain.filter;

public class ErreichbarkeitTagFilter extends IntegerFilter {
    @Override
    String getTextRepresentation() {
        switch (getFilterValue()) {
            case 0: return "Montag";
            case 1: return "Dienstag";
            case 2: return "Mittwoch";
            case 3: return "Donnerstag";
            case 4: return "Freitag";
            case 5: return "Samstag";
            default: return "Unbekannter Tag";
        }
    }
}
