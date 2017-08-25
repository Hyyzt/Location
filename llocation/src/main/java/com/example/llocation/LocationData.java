package com.example.llocation;

import android.location.Location;

public class LocationData {
    private String Type;
    private Location location;
    private int Statellites;

    public LocationData(String type, Location location, int count) {
        this.Type = type;
        this.location = location;
        this.Statellites = count;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getStatellites() {
        return Statellites;
    }

    public void setStatellites(int statellites) {
        Statellites = statellites;
    }
}
