package ru.ssau.tk.ildar.Practice.transportation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RouteTest {

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

}
