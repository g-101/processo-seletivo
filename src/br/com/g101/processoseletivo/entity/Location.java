package br.com.g101.processoseletivo.entity;


public class Location {
    private String city;
    private String state;

    public Location() {
    }

    public Location(String city, String state) {
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString() {
        return
                city + " - " +
                state;
    }

    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }


}
