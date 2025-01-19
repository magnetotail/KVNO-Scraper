package de.foospace.two.domain;

public class SearchResult {

    private Person[] personList;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    private int totalCount;

    public Person[] getPersons() {
        return personList;
    }

    public void setPersons(Person[] persons) {
        this.personList = persons;
    }
}
