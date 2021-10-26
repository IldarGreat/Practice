package ru.ssau.tk.ildar.Practice.transportation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Route implements Iterable<Location> {
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

    public Location getFirstLocation() {
        return locations.get(0);
    }

    public Location getLastLocation() {
        return locations.get(locations.size() - 1);
    }


    @Override
    public Iterator<Location> iterator() {
        return new Iterator<>() {
            int element = 0;

            @Override
            public boolean hasNext() {
                return element < locations.size();
            }

            @Override
            public Location next() {
                if (!hasNext()) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                return getLocation(element++);
            }
        };
    }
}
