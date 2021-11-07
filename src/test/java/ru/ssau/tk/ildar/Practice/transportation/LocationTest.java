package ru.ssau.tk.ildar.Practice.transportation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LocationTest {

    @Test
    public static void testEquals() {
        Location locationOne = new Location();
        locationOne.setName("Samara");
        locationOne.setId(1);
        Location locationTwo = new Location();
        locationTwo.setName("Moscow");
        locationTwo.setId(2);
        Location locationThree = new Location();
        locationThree.setName("London");
        locationThree.setId(3);
        Location locationFour = new Location();
        locationFour.setName("Florida");
        locationFour.setId(1);
        Location locationFive = new Location();
        locationFive.setName("Florida");
        locationFive.setId(3);
        Assert.assertEquals(locationFour, locationOne);
        Assert.assertNotEquals(locationFive, locationFour);
        Assert.assertNotEquals(locationTwo, locationThree);
        locationTwo.setId(3);
        Assert.assertEquals(locationTwo, locationThree);
    }

    @Test
    public void testComparator() {
        CompanyModelTest test = new CompanyModelTest();
        List<Location> list = new ArrayList<>();
        list.add(test.waypointThree);
        list.add(test.waypointTwo);
        list.add(test.waypointOne);
        list.add(test.waypointSix);
        list.add(test.waypointSeven);
        list.add(test.waypointEight);
        list.add(test.waypointThree);
        list.add(test.settlementTen);
        list.add(test.settlementNine);
        list.add(test.settlementTen);
        list.add(test.settlementThree);
        list.add(test.settlementEight);
        list.add(test.settlementSeven);
        list.add(test.settlementFour);
        Comparator<Location> comparator = Location.comparator;
        list.sort(comparator);
        for (Location location : list) {
            System.out.println(location);
        }
    }

}