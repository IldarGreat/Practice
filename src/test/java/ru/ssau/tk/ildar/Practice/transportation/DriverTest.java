package ru.ssau.tk.ildar.Practice.transportation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

import static ru.ssau.tk.ildar.Practice.Gender.*;

public class DriverTest {

    @Test
    public void testTestEquals() {
        Driver driverOne = new Driver();
        Driver driverTwo = new Driver();
        Driver driverThree = new Driver();
        Driver driverFour = new Driver();
        Driver driverFive = new Driver();
        Driver driverSix = new Driver();
        Date date = new Date();
        date.setTime(4324823L);
        driverOne.setGender(MALE);
        driverOne.setLicenseExpirationDate(date);
        driverOne.setId(47523872);
        driverOne.setName("Ildar");
        driverTwo.setGender(FEMALE);
        driverTwo.setLicenseExpirationDate(date);
        driverTwo.setId(43256765);
        driverTwo.setName("Tom");
        driverThree.setGender(MALE);
        driverThree.setLicenseExpirationDate(date);
        driverThree.setId(47523872);
        driverThree.setName("Tom");
        driverFour.setGender(FEMALE);
        driverFour.setLicenseExpirationDate(date);
        driverFour.setId(23353467);
        driverFour.setName("John");
        driverFive.setGender(MALE);
        driverFive.setLicenseExpirationDate(date);
        driverFive.setId(47523872);
        driverFive.setName("Hack");
        driverSix.setGender(FEMALE);
        driverSix.setLicenseExpirationDate(date);
        driverSix.setId(23353467);
        driverSix.setName("Ildar");
        Assert.assertEquals(driverOne, driverThree);
        Assert.assertEquals(driverOne, driverFive);
        Assert.assertEquals(driverThree, driverFive);
        Assert.assertEquals(driverFour, driverSix);
        Assert.assertNotEquals(driverOne, driverSix);
        Assert.assertNotEquals(driverTwo, driverThree);
    }

    @Test
    public void testTestToString() {
        Driver driverOne = new Driver();
        Driver driverTwo = new Driver();
        Driver driverThree = new Driver();
        Driver driverFour = new Driver();
        Driver driverFive = new Driver();
        Driver driverSix = new Driver();
        Date date = new Date();
        date.setTime(0);
        driverOne.setGender(MALE);
        driverOne.setLicenseExpirationDate(date);
        driverOne.setId(47523872);
        driverOne.setName("Ildar");
        driverTwo.setGender(FEMALE);
        driverTwo.setLicenseExpirationDate(date);
        driverTwo.setId(43256765);
        driverTwo.setName("Tom");
        driverThree.setGender(MALE);
        driverThree.setLicenseExpirationDate(date);
        driverThree.setId(47523872);
        driverThree.setName("Tom");
        driverFour.setGender(FEMALE);
        driverFour.setLicenseExpirationDate(date);
        driverFour.setId(23353467);
        driverFour.setName("John");
        driverFive.setGender(MALE);
        driverFive.setLicenseExpirationDate(date);
        driverFive.setId(47523872);
        driverFive.setName("Hack");
        driverSix.setGender(FEMALE);
        driverSix.setLicenseExpirationDate(date);
        driverSix.setId(23353467);
        driverSix.setName("Ildar");
        System.out.println(driverOne);
        System.out.println(driverTwo);
        System.out.println(driverThree);
        System.out.println(driverFour);
        System.out.println(driverFive);
        System.out.println(driverSix);
    }
}