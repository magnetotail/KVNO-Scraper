package de.foospace.two.domain.filter;

public class GeschlechtFilter extends IntegerFilter {

    @Override
    String getTextRepresentation() {
        switch (getFilterValue()) {
            case 1: return "Männlich";
            case 2: return "Weiblich";
            default: return "Unbekannt";
        }
    }
}
