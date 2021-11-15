package ru.ssau.tk.ildar.Practice.transportation;

import java.util.*;
import java.util.stream.Collectors;

public class APIModel {

    public static List<Location> aboveTheEquator(List<Location> allLocations) {
        return allLocations.stream()
                .filter(location -> location != null && location.getLatitude() > 0)
                .collect(Collectors.toList());
    }

    public static List<String> waypointsNames(List<Location> allLocations) {
        return allLocations.stream()
                .filter(location -> location instanceof Waypoint)
                .filter(location -> ((Waypoint) location).getType() != null)
                .map(Location::getName)
                .collect(Collectors.toList());
    }

}
