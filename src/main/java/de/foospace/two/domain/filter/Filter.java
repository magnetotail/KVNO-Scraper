package de.foospace.two.domain.filter;

public abstract class Filter<T> {
    private int resultAmount;
    int getResultAmount() {
        return resultAmount;
    }
    abstract T getFilterValue();
    abstract String getTextRepresentation();

    @Override
    public String toString() {
        return getTextRepresentation();
    }
}
