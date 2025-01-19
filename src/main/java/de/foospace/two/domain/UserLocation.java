package de.foospace.two.domain;

public class UserLocation {
    public UserLocation() {
        this(51.4457967, 6.9761637);
    }

    public UserLocation(double lat, double lng) {
        Lat = lat;
        Lng = lng;
    }

    private double Lat;
    private double Lng;
}
