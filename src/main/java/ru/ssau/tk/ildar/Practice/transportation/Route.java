package ru.ssau.tk.ildar.Practice.transportation;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private final List<Location> locations = new ArrayList<>();

    public List<Location> getLocations() {
        return locations;
    }

    public Location getLocation(int index) {
        return locations.get(index);
    }

    public void add(Location location) {
        locations.add(location);
    }

    public void add(int index, Location location) {
        locations.add(index, location);
    }

    public void remove(int index) {
        locations.remove(index);
    }


}
