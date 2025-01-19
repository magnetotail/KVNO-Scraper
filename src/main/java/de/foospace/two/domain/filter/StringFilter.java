package de.foospace.two.domain.filter;

public abstract class StringFilter extends Filter<String> {

    private String filterValue;

    @Override
    String getTextRepresentation() {
        return filterValue;
    }

    @Override
    public String getFilterValue() {
        return filterValue;
    }
}
