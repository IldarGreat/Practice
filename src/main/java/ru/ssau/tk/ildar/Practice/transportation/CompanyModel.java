package ru.ssau.tk.ildar.Practice.transportation;

import ru.ssau.tk.ildar.Practice.Gender;

import java.util.*;

public class CompanyModel {
    protected Collection<Location> allLocations = new LinkedHashSet<>();
    protected Collection<Route> allRoutes = new LinkedHashSet<>();
    protected Collection<Driver> allDrivers = new LinkedHashSet<>();
    private int maxId = 0;

    public Collection<Location> getAllLocations() {
        return allLocations;
    }

    public Collection<Route> getAllRoutes() {
        return allRoutes;
    }

    public Collection<Driver> getAllDrivers() {
        return allDrivers;
    }

    public Settlement addSettlement(String name, double latitude, double longitude, SettlementType type, int population) {
        Settlement settlement = new Settlement();
        settlement.setSettlement(population);
        settlement.setSettlementType(type);
        settlement.setLongitude(longitude);
        settlement.setLatitude(latitude);
        settlement.setName(name);
        settlement.setId(++maxId);
        allLocations.add(settlement);
        return settlement;
    }

    public Waypoint addWaypoint(String name, double latitude, double longitude, WaypointType type, Settlement settlement) {
        Waypoint waypoint = new Waypoint();
        waypoint.setName(name);
        waypoint.setLatitude(latitude);
        waypoint.setLongitude(longitude);
        waypoint.setType(type);
        waypoint.setSettlement(settlement);
        waypoint.setId(++maxId);
        allLocations.add(waypoint);
        return waypoint;
    }

    public Driver addDriver(String name, Gender gender, Date licenseExpirationDate) {
        Driver driver = new Driver();
        driver.setName(name);
        driver.setGender(gender);
        driver.setLicenseExpirationDate(licenseExpirationDate);
        driver.setId(++maxId);
        allDrivers.add(driver);
        return driver;
    }

    public Route addRoute(List<Location> locations) {
        Route route = new Route();
        for (Location location : locations) {
            route.add(location);
        }
        allRoutes.add(route);
        return route;
    }

}
