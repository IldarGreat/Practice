package ru.ssau.tk.ildar.Practice.transportation;

import java.util.List;
import java.util.stream.Collectors;

public class APIModel {

    public static List<Location> aboveTheEquator(List<Location> allLocations){
        return allLocations.stream()
                .filter(location -> location!=null && location.getLatitude()>0)
                .collect(Collectors.toList());
    }
}
