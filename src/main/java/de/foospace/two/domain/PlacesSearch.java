package de.foospace.two.domain;

public class PlacesSearch {

    private final int near = 10;
    private String address;
    private int page;
    private int pageSize;

    private UserLocation UserLocation = new UserLocation();

    private FilterModel FilterModel = new FilterModel();

    public PlacesSearch(String address, int page, int pageSize) {
        this.address = address;
        this.page = page;
        this.pageSize = pageSize;
    }
}
