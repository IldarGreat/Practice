package ru.ssau.tk.ildar.Practice.transportation;

import java.util.*;

public class RouteLengthComparator implements Comparator<Route> {
    private final Map<Route, Double> routeLengthMap = new LinkedHashMap<>();

    @Override
    public int compare(Route routeOne, Route routeTwo) {
        if (!routeLengthMap.containsKey(routeOne)) {
            routeLengthMap.put(routeOne, routeOne.length());
        }
        if (!routeLengthMap.containsKey(routeTwo)) {
            routeLengthMap.put(routeTwo, routeTwo.length());
        }
        return Double.compare(routeLengthMap.get(routeOne), routeLengthMap.get(routeTwo));
    }

}
