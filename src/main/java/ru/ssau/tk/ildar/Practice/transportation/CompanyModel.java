package ru.ssau.tk.ildar.Practice.transportation;

import java.util.*;

public class CompanyModel {
    protected Collection<Location> allLocations = new LinkedHashSet<>();
    protected Collection<Route> allRoutes = new LinkedHashSet<>();
    protected Collection<Driver> allDrivers = new LinkedHashSet<>();

    public Collection<Location> getAllLocations() {
        return allLocations;
    }

    public Collection<Route> getAllRoutes() {
        return allRoutes;
    }

    public Collection<Driver> getAllDrivers() {
        return allDrivers;
    }
}
