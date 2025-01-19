package de.foospace.two.domain.filter;

public abstract class IntegerFilter extends Filter<Integer> {
    private Integer filterValue;

    @Override
    public Integer getFilterValue() {
        return filterValue;
    }
}
