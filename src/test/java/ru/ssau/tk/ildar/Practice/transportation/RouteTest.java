package ru.ssau.tk.ildar.Practice.transportation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static ru.ssau.tk.ildar.Practice.transportation.SettlementType.*;
import static ru.ssau.tk.ildar.Practice.transportation.WaypointType.*;

public class RouteTest {
    public static Route route = new Route();
    public static Location locationOne = new Location();
    public static Location locationTwo = new Location();
    public static Location locationThree = new Location();

    @Test
    public static void simpleTest() {
        Route route = new Route();
        Location locationOne = new Location();
        Location locationTwo = new Location();
        Location locationThree = new Location();
        route.add(locationTwo);
        route.add(locationThree);
        route.add(0, locationOne);
        Assert.assertEquals(route.getLocation(0), locationOne);
        Assert.assertEquals(route.getLocation(1), locationTwo);
        Assert.assertEquals(route.getLocation(2), locationThree);
        route.remove(2);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> System.out.println(route.getLocation(2)));
        List<Location> routeTwo = new ArrayList<>();
        routeTwo.add(locationOne);
        routeTwo.add(locationTwo);
        Assert.assertEquals(route.getLocations(), routeTwo);
    }

    @Test
    public static void getFirstAndLastLocationTest() {
        route.add(locationOne);
        route.add(locationTwo);
        route.add(locationThree);
        Assert.assertEquals(route.getFirstLocation(), locationOne);
        Assert.assertEquals(route.getLastLocation(), locationThree);
    }

    @Test
    public static void iteratorTest() {
        Route route = new Route();
        route.add(locationOne);
        route.add(locationTwo);
        route.add(locationThree);
        int size = 0;
        Iterator<Location> container = route.iterator();
        for (Location location : route) {
            Assert.assertEquals(location, container.next());
            size++;
        }
        Assert.assertEquals(size, 3);
    }

    @Test
    public static void removeTest() {
        Route route = new Route();
        Location locationOne = new Location();
        Location locationTwo = new Location();
        Location locationThree = new Location();
        Location locationFour = new Location();
        locationOne.setId(1);
        locationTwo.setId(2);
        locationThree.setId(3);
        locationFour.setId(1);
        locationOne.setName("Russia");
        locationTwo.setName("Some village");
        locationThree.setName("Dungeon");
        locationFour.setName("London");
        route.add(locationOne);
        route.add(locationTwo);
        route.add(locationThree);
        route.add(locationFour);
        route.remove(locationFour);
        Assert.assertEquals(route.getLocation(0).getId(), 2);
        Assert.assertEquals(route.getLocation(1).getId(), 3);
        Assert.assertEquals(route.getLocation(2).getId(), 1);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> System.out.println(route.getLocation(3)));
        route.remove(locationFour);
        Assert.assertEquals(route.getLocation(0).getId(), 2);
        Assert.assertEquals(route.getLocation(1).getId(), 3);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> System.out.println(route.getLocation(2)));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> System.out.println(route.getLocation(3)));
    }

    @Test
    public static void testEquals() {
        Route route = new Route();
        Location locationOne = new Location();
        Location locationTwo = new Location();
        Location locationThree = new Location();
        Location locationFour = new Location();
        locationOne.setId(1);
        locationTwo.setId(2);
        locationThree.setId(3);
        locationFour.setId(4);
        locationOne.setName("Russia");
        locationTwo.setName("Some village");
        locationThree.setName("Dungeon");
        locationFour.setName("London");
        route.add(locationOne);
        route.add(locationTwo);
        route.add(locationThree);
        route.add(locationFour);
        Route routeTwo = new Route();
        Location locationSix = new Location();
        Location locationSeven = new Location();
        Location locationEight = new Location();
        Location locationNine = new Location();
        locationSix.setId(1);
        locationSeven.setId(2);
        locationEight.setId(3);
        locationNine.setId(4);
        locationOne.setName("Africa");
        locationTwo.setName("Town");
        locationThree.setName("America");
        locationFour.setName("San Andreas");
        routeTwo.add(locationSix);
        routeTwo.add(locationSeven);
        routeTwo.add(locationEight);
        routeTwo.add(locationNine);
        Assert.assertEquals(routeTwo, route);
        routeTwo.add(locationEight);
        Assert.assertNotEquals(routeTwo, route);
        routeTwo.remove(locationSix);
        routeTwo.add(locationSix);
        Assert.assertNotEquals(routeTwo, route);
    }

    @Test
    public static void testToString() {
        Settlement locationOne = new Settlement();
        Settlement locationTwo = new Settlement();
        Waypoint locationThree = new Waypoint();
        Waypoint locationFour = new Waypoint();
        Settlement settlement = new Settlement();
        settlement.setSettlementType(CITY);
        settlement.setName("Unknown");
        settlement.setLatitude(0);
        settlement.setLongitude(0);
        locationOne.setSettlementType(CITY);
        locationOne.setName("Kazan");
        locationOne.setLatitude(55.47);
        locationOne.setLongitude(49.6);
        route.add(locationOne);
        locationTwo.setSettlementType(VILLAGE);
        locationTwo.setName("KFC");
        locationTwo.setLatitude(53.09);
        locationTwo.setLongitude(48.28);
        route.add(locationTwo);
        locationThree.setSettlement(settlement);
        locationThree.setType(DEPOT);
        locationThree.setName("Florida");
        locationThree.setLatitude(32.09);
        locationThree.setLongitude(43.28);
        route.add(locationThree);
        locationFour.setSettlement(settlement);
        locationFour.setType(WAREHOUSE);
        locationFour.setName("America");
        locationFour.setLatitude(30.09);
        locationFour.setLongitude(41.28);
        route.add(locationFour);
        System.out.println(route);
    }

    @Test
    public static void testLength() {
        CompanyModelTest ildarCorporation = new CompanyModelTest();
        System.out.println(ildarCorporation.routeOne.length());
        System.out.println(ildarCorporation.routeTwo.length());
        System.out.println(ildarCorporation.routeFive.length());
    }

    @Test
    public static void testCompareTo() {
        CompanyModelTest ildarCorporation = new CompanyModelTest();
        List<Route> routeList = new ArrayList<>();
        routeList.add(ildarCorporation.routeTwo);
        routeList.add(ildarCorporation.routeThree);
        routeList.add(ildarCorporation.routeOne);
        routeList.add(ildarCorporation.routeFive);
        routeList.add(ildarCorporation.routeFour);
        Collections.sort(routeList);
        for (Route route : routeList) {
            System.out.println(route.length());
        }
    }

    @Test
    public static void testComparator() {
        CompanyModelTest ildarCorporation = new CompanyModelTest();
        List<Route> routeList = new ArrayList<>();
        routeList.add(ildarCorporation.routeTwo);
        routeList.add(ildarCorporation.routeThree);
        routeList.add(ildarCorporation.routeOne);
        routeList.add(ildarCorporation.routeFive);
        routeList.add(ildarCorporation.routeFour);
        Comparator<Route> comparator = Route.byLengthComparator;
        routeList.sort(comparator);
        for (Route route : routeList) {
            System.out.println(route.length());
        }
    }

    @Test
    public static void testFirstLocationWithLetter() {
        CompanyModelTest ildarCorporation = new CompanyModelTest();
        Route route = new Route();
        route.add(ildarCorporation.settlementOne);
        route.add(ildarCorporation.settlementTwo);
        route.add(ildarCorporation.settlementThree);
        route.add(ildarCorporation.settlementFour);
        route.add(ildarCorporation.settlementFive);
        route.add(ildarCorporation.waypointOne);
        route.add(ildarCorporation.waypointTwo);
        route.add(ildarCorporation.waypointThree);
        route.add(ildarCorporation.waypointFour);
        route.add(ildarCorporation.waypointFive);
        Location location = route.firstLocationWithLetter("L");
        System.out.println(location.getName());
        location = route.firstLocationWithLetter("A");
        System.out.println(location.getName());
    }

    @Test
    public static void testAnyName() {
        List<Location> locations;
        locations = new CompanyModelTest().allLocation();
        Route route = new Route();
        for (Location location : locations) {
            route.add(location);
        }
        Assert.assertTrue(route.anyName("Cocks"));
        Assert.assertFalse(route.anyName("Russia"));
    }

    @Test
    public static void testAllSettlementsOrWaypointsInSettlements() {
        List<Location> locations;
        locations = new CompanyModelTest().allLocation();
        Route route = new Route();
        for (Location location : locations) {
            route.add(location);
        }
        Assert.assertTrue(route.allSettlementsOrWaypointsInSettlements());
        Waypoint waypointWithoutSettlement = new Waypoint();
        route.add(waypointWithoutSettlement);
        Assert.assertFalse(route.allSettlementsOrWaypointsInSettlements());
    }

    @Test
    public static void testNoneEmpty() {
        List<Location> locations;
        locations = new CompanyModelTest().allLocation();
        Route route = new Route();
        for (Location location : locations) {
            route.add(location);
        }
        Assert.assertFalse(route.noneEmpty());
    }

    @Test
    public static void testSameLocation() {
        List<Location> locations;
        locations = new CompanyModelTest().allLocation();
        Route route = new Route();
        for (Location location : locations) {
            route.add(location);
        }
        System.out.println(route.sameLocation(55.78, 49.12, 0.01));
        Assert.assertEquals(new CompanyModelTest().settlementOne, route.sameLocation(55.78, 49.12, 0.01));
    }
}
