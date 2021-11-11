package ru.ssau.tk.ildar.Practice.transportation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class APIModelTest {

    @Test
    public void testAboveTheEquator() {
        List<Location> locations = new ArrayList<>();
        Location locationOne = new Location();
        Location locationTwo = new Location();
        Location locationThree = new Location();
        Location locationFour = new Location();
        locationOne.setLatitude(20);
        locationTwo.setLatitude(40);
        locationThree.setLatitude(-10);
        locationFour.setLatitude(-30);
        locations.add(locationOne);
        locations.add(locationTwo);
        locations.add(locationThree);
        locations.add(locationFour);
        Assert.assertEquals(APIModel.aboveTheEquator(locations).size(), 2);
        Assert.assertEquals(APIModel.aboveTheEquator(locations).get(0).getLatitude(), 20.0);
        Assert.assertEquals(APIModel.aboveTheEquator(locations).get(1).getLatitude(), 40.0);
    }

}