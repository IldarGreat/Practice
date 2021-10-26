package ru.ssau.tk.ildar.Practice.transportation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocationTest {

    @Test
    public static void testEquals(){
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
        Assert.assertNotEquals(locationTwo,locationThree);
        locationTwo.setId(3);
        Assert.assertEquals(locationTwo,locationThree);
    }

}