package ru.ssau.tk.ildar.Practice.transportation;

import java.util.*;
import java.util.stream.Stream;

public final class Route implements Iterable<Location>, Comparable<Route> {
    private final List<Location> locations = new ArrayList<>();
    public static final double EARTH_RADIUS = 6371.0;

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

    public void remove(Location location) {
        locations.remove(location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(locations, route.locations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locations);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Location location : locations) {
            stringBuilder.append(location);
            stringBuilder.append("\n");
        }
        return String.valueOf(stringBuilder);
    }

    private double degreeToRad(double degree) {
        return degree * Math.PI / 180.0;
    }

    public double length() {
        if (locations.size() < 2) {
            return 0;
        }
        double length = 0.0;
        for (int element = 0; element < locations.size() - 1; element++) {
            double latitudeOne;
            double longitudeOne;
            double latitudeTwo;
            double longitudeTwo;
            latitudeOne = locations.get(element).getLatitude();
            longitudeOne = locations.get(element).getLongitude();
            latitudeTwo = locations.get(element + 1).getLatitude();
            longitudeTwo = locations.get(element + 1).getLongitude();
            double dLatitude = degreeToRad(latitudeOne - latitudeTwo);
            double dLongitude = degreeToRad(longitudeOne - longitudeTwo);
            double a = Math.sin(dLatitude / 2d) * Math.sin(dLatitude / 2d) +
                    Math.cos(degreeToRad(latitudeOne)) * Math.cos(degreeToRad(latitudeTwo)) *
                            Math.sin(dLongitude / 2d) * Math.sin(dLongitude / 2d);
            double c = 2d * Math.atan2(Math.sqrt(a), Math.sqrt(1d - a));
            length = length + EARTH_RADIUS * c;
        }
        return length;
    }

    @Override
    public int compareTo(Route object) {
        if (object == null) {
            throw new NullPointerException();
        }
        return Double.compare(length(), object.length());
    }

    public static Comparator<Route> byLengthComparator = Route::compareTo;

    private Stream<Location> streamOfLocations() {
        return locations.stream();
    }

    public Location firstLocationWithLetter(String letters) {
        return streamOfLocations()
                .filter(location -> location.getName().startsWith(letters))
                .findFirst()
                .orElse(new Location());
    }
}
