package de.foospace.two.domain;

public class FilterModel {
    public String[] getPsychotherapieVerfahrenFilter() {
        return psychotherapieVerfahrenFilter;
    }

    public void setPsychotherapieVerfahrenFilter(String[] psychotherapieVerfahrenFilter) {
        this.psychotherapieVerfahrenFilter = psychotherapieVerfahrenFilter;
    }

    private String[] psychotherapieVerfahrenFilter = {"Verhaltenstherapie für Erwachsene"};
}
