package ru.ssau.tk.ildar.Practice.transportation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static ru.ssau.tk.ildar.Practice.Gender.*;
import static ru.ssau.tk.ildar.Practice.transportation.SettlementType.*;
import static ru.ssau.tk.ildar.Practice.transportation.WaypointType.*;


public class CompanyModelTest {
    public static CompanyModel companyModel = new CompanyModel();

    @Test
    public void testGetAllLocations() {
        Location locationOne = new Location();
        Location locationTwo = new Location();
        Location locationThree = new Location();
        Location locationFour = new Location();
        Location locationFive = new Location();
        locationOne.setId(1);
        locationTwo.setId(0);
        locationThree.setId(1);
        locationFour.setId(2);
        locationFive.setId(0);
        Assert.assertTrue(companyModel.allLocations.add(locationOne));
        Assert.assertTrue(companyModel.allLocations.add(locationTwo));
        Assert.assertFalse(companyModel.allLocations.add(locationThree));
        Assert.assertTrue(companyModel.allLocations.add(locationFour));
        Assert.assertFalse(companyModel.allLocations.add(locationFive));
    }

    @Test
    public void testGetAllRoutes() {
        Location locationOne = new Location();
        locationOne.setId(1);
        Location locationTwo = new Location();
        locationTwo.setId(0);
        Location locationThree = new Location();
        locationThree.setId(1);
        Location locationFour = new Location();
        locationFour.setId(2);
        Location locationFive = new Location();
        locationFive.setId(0);
        Route routeOne = new Route();
        routeOne.add(locationOne);
        routeOne.add(locationFive);
        Route routeTwo = new Route();
        routeTwo.add(locationThree);
        routeTwo.add(locationTwo);
        Route routeThree = new Route();
        routeThree.add(locationFive);
        routeThree.add(locationFour);
        Assert.assertTrue(companyModel.allRoutes.add(routeOne));
        Assert.assertFalse(companyModel.allRoutes.add(routeTwo));
        Assert.assertTrue(companyModel.allRoutes.add(routeThree));
    }

    @Test
    public void testGetAllDrivers() {
        Driver driverOne = new Driver();
        driverOne.setId(1);
        Driver driverTwo = new Driver();
        driverTwo.setId(0);
        Driver driverThree = new Driver();
        driverThree.setId(1);
        Driver driverFour = new Driver();
        driverFour.setId(0);
        Assert.assertTrue(companyModel.allDrivers.add(driverOne));
        Assert.assertTrue(companyModel.allDrivers.add(driverTwo));
        Assert.assertFalse(companyModel.allDrivers.add(driverThree));
        Assert.assertFalse(companyModel.allDrivers.add(driverFour));
    }

    @Test
    public static void testAddSettlement() {
        Collection<Settlement> allSettlement = new LinkedHashSet<>();
        CompanyModel companyModel = new CompanyModel();
        allSettlement.add(companyModel.addSettlement("Kazan", 54.3, 48.9, CITY, 1534392));
        Assert.assertEquals(companyModel.getAllLocations().size(), 1);
        allSettlement.add(companyModel.addSettlement("Samara", 48.9, 53.2, CITY, 1024392));
        Assert.assertEquals(companyModel.getAllLocations().size(), 2);
        allSettlement.add(companyModel.addSettlement("Moscow", 57.2, 54.2, CITY, 9224392));
        Assert.assertEquals(companyModel.getAllLocations().size(), 3);
        int id = 0;
        for (Settlement settlement : allSettlement) {
            Assert.assertEquals(settlement.getId(), ++id);
        }
        Assert.assertEquals(allSettlement, companyModel.getAllLocations());
        System.out.println(companyModel.getAllLocations().toString());
    }

    @Test
    public static void testAddWaypoint() {
        Collection<Waypoint> allWaypoint = new LinkedHashSet<>();
        CompanyModel companyModel = new CompanyModel();
        allWaypoint.add(companyModel.addWaypoint("UNKNOWN", 0, 0, EMPTY, null));
        Assert.assertEquals(companyModel.getAllLocations().size(), 1);
        Settlement settlement = new Settlement();
        settlement.setSettlementType(CITY);
        settlement.setName("New-York");
        settlement.setLongitude(43.2);
        settlement.setLatitude(53.2);
        allWaypoint.add(companyModel.addWaypoint("Boss", 43.24, 53.25, DEPOT, settlement));
        Assert.assertEquals(companyModel.getAllLocations().size(), 2);
        allWaypoint.add(companyModel.addWaypoint("Winston", 43.431, 53.54, DEPOT, settlement));
        Assert.assertEquals(companyModel.getAllLocations().size(), 3);
        int id = 0;
        for (Location waypoint : allWaypoint) {
            Assert.assertEquals(waypoint.getId(), ++id);
        }
        Assert.assertEquals(allWaypoint, companyModel.getAllLocations());
        System.out.println(companyModel.getAllLocations().toString());
    }

    @Test
    public static void testAddDriver() {
        Collection<Driver> allDrivers = new LinkedHashSet<>();
        CompanyModel companyModel = new CompanyModel();
        allDrivers.add(companyModel.addDriver("Ildar", MALE, new Date(468376429863482L)));
        Assert.assertEquals(companyModel.getAllDrivers().size(), 1);
        allDrivers.add(companyModel.addDriver("Tom Hawk", MALE, new Date(468376429863482L)));
        Assert.assertEquals(companyModel.getAllDrivers().size(), 2);
        allDrivers.add(companyModel.addDriver("Kate", FEMALE, new Date(468376421263482L)));
        Assert.assertEquals(companyModel.getAllDrivers().size(), 3);
        int id = 0;
        for (Driver driver : allDrivers) {
            Assert.assertEquals(driver.getId(), ++id);
        }
        Assert.assertEquals(allDrivers, companyModel.getAllDrivers());
        System.out.println(companyModel.getAllDrivers().toString());
    }

    @Test
    public static void testAddRoute() {
        CompanyModel companyModel = new CompanyModel();
        Location locationOne = new Location();
        locationOne.setId(0);
        Location locationTwo = new Location();
        locationTwo.setId(1);
        Location locationThree = new Location();
        locationThree.setId(2);
        Location locationFour = new Location();
        locationFour.setId(3);
        List<Location> locations = new ArrayList<>();
        locations.add(locationOne);
        locations.add(locationTwo);
        Route routeOne = companyModel.addRoute(locations);
        locations.remove(0);
        locations.remove(0);
        locations.add(locationThree);
        locations.add(locationFour);
        Route routeTwo = companyModel.addRoute(locations);
        Assert.assertEquals(companyModel.getAllRoutes().size(), 2);
        Assert.assertTrue(companyModel.getAllRoutes().contains(routeOne));
        Assert.assertTrue(companyModel.getAllRoutes().contains(routeTwo));
        System.out.println(locationOne);
    }

    @Test
    public static void testAssignRoute() {
        CompanyModel companyModel = new CompanyModel();
        Waypoint waypoint = new Waypoint();
        waypoint.setId(41241);
        Settlement settlement = new Settlement();
        settlement.setId(314523);
        Route route = new Route();
        route.add(waypoint);
        route.add(settlement);
        Driver driver = new Driver();
        driver.setId(54364);
        companyModel.assignRoute(driver, route);
        Assert.assertEquals(companyModel.getDriverRouteMap().get(driver), route);
    }
}