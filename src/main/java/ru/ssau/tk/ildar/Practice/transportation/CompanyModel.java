package ru.ssau.tk.ildar.Practice.transportation;

import ru.ssau.tk.ildar.Practice.Gender;

import java.util.*;
import java.util.stream.Collectors;

import static ru.ssau.tk.ildar.Practice.transportation.WaypointType.*;

public class CompanyModel {
    protected Collection<Location> allLocations = new LinkedHashSet<>();
    protected Collection<Route> allRoutes = new LinkedHashSet<>();
    protected Collection<Driver> allDrivers = new LinkedHashSet<>();
    protected Map<Driver, Route> driverRouteMap = new LinkedHashMap<>();
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

    public Map<Driver, Route> getDriverRouteMap() {
        return driverRouteMap;
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

    public void assignRoute(Driver driver, Route route) {
        driverRouteMap.put(driver, route);
    }

    public static void sort(List<Settlement> settlements, Comparator<? super Settlement> comparator) {
        settlements.sort(comparator);
    }

    public static void sortByName(List<? extends Location> locations) {
        locations.sort(Comparator.comparing(Location::getName));
    }

    public Map<Driver, Route> sortedMap(List<Driver> drivers) {
        Map<Driver, Route> sortedMap = new TreeMap<>(Comparator.comparing(Driver::getName));
        for (Driver driver : drivers) {
            if (driverRouteMap.containsKey(driver)) {
                sortedMap.put(driver, driverRouteMap.get(driver));
            }
        }
        return sortedMap;
    }

    public Map<Settlement, SettlementType> sortedSettlement(List<Location> locations) {
        Map<Settlement, SettlementType> sortedSettlement = new TreeMap<>((objectOne, objectTwo) -> objectTwo.getSettlement() - objectOne.getSettlement());
        for (Location location : locations) {
            if (location instanceof Settlement) {
                sortedSettlement.put((Settlement) location, ((Settlement) location).getSettlementType());
            }
        }
        return sortedSettlement;
    }

    public Map<WaypointType, List<Waypoint>> sortedWaypoints(List<Location> locations) {
        List<Waypoint> waypointDepot = new ArrayList<>();
        List<Waypoint> waypointWarehouse = new ArrayList<>();
        List<Waypoint> waypointEmpty = new ArrayList<>();
        Map<WaypointType, List<Waypoint>> sortedWaypoints = new LinkedHashMap<>();
        for (Location location : locations) {
            if (location instanceof Waypoint) {
                if (((Waypoint) location).getType() == DEPOT) {
                    waypointDepot.add((Waypoint) location);
                } else if (((Waypoint) location).getType() == WAREHOUSE) {
                    waypointWarehouse.add((Waypoint) location);
                } else if (((Waypoint) location).getType() == EMPTY) {
                    waypointEmpty.add((Waypoint) location);
                }
            }
        }
        sortedWaypoints.put(DEPOT, waypointDepot);
        sortedWaypoints.put(WAREHOUSE, waypointWarehouse);
        sortedWaypoints.put(EMPTY, waypointEmpty);
        return sortedWaypoints;
    }

    public double minLength() {
        return allRoutes.stream()
                .mapToDouble(Route::length)
                .min()
                .orElse(0);
    }

    public Driver latestLicense() {
        return allDrivers.stream()
                .max((driverOne, driverTwo) -> (int) (driverOne.getLicenseExpirationDate().getTime() - driverTwo.getLicenseExpirationDate().getTime()))
                .orElse(null);
    }

    public double lengthOfAllRoutes() {
        return allRoutes.stream()
                .mapToDouble(Route::length)
                .sum();
    }

    public static Map<Waypoint, Settlement> waypointSettlementMap(Collection<Waypoint> waypoints) {
        return waypoints.stream()
                .filter(waypoint -> waypoint.getSettlement() != null)
                .collect(Collectors.toMap(waypoint -> waypoint, Waypoint::getSettlement));
    }

    public static Map<Settlement, Set<Waypoint>> settlementSetMap(Collection<Waypoint> waypoints) {
        return waypoints.stream()
                .filter(waypoint -> waypoint.getSettlement() != null)
                .collect(Collectors.groupingBy(Waypoint::getSettlement, Collectors.toSet()));
    }
}
