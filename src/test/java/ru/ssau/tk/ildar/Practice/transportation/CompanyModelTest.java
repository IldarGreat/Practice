package ru.ssau.tk.ildar.Practice.transportation;

import org.testng.Assert;
import org.testng.annotations.Test;


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
}