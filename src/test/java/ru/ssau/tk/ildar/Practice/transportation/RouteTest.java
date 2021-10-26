package ru.ssau.tk.ildar.Practice.transportation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> route.getLocation(2));
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

}
