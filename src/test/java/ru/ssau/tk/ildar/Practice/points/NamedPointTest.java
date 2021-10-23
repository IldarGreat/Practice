package ru.ssau.tk.ildar.Practice.points;

import org.testng.Assert;
import org.testng.annotations.Test;


public class NamedPointTest {

    @Test
    public void testNamedPointWithoutParameters() {
        NamedPoint namedPoint = new NamedPoint();
        Assert.assertEquals(namedPoint.getX(), 0.0);
        Assert.assertEquals(namedPoint.getY(), 0.0);
        Assert.assertEquals(namedPoint.getZ(), 0.0);
        Assert.assertEquals(namedPoint.getName(), "Origin");
    }

    @Test
    public void testNamedPointWithThreeParameters() {
        NamedPoint namedPoint = new NamedPoint(1, 2, 3);
        Assert.assertEquals(namedPoint.getX(), 1.0);
        Assert.assertEquals(namedPoint.getY(), 2.0);
        Assert.assertEquals(namedPoint.getZ(), 3.0);
        Assert.assertNull(namedPoint.getName());
    }

    @Test
    public void testNamedPointWithFourParameters() {
        NamedPoint namedPoint = new NamedPoint(1, 2, 3, "Ildar");
        Assert.assertEquals(namedPoint.getX(), 1.0);
        Assert.assertEquals(namedPoint.getY(), 2.0);
        Assert.assertEquals(namedPoint.getZ(), 3.0);
        Assert.assertEquals(namedPoint.getName(), "Ildar");
    }

    @Test
    public void testReset() {
        NamedPoint namedPoint = new NamedPoint();
        namedPoint.reset();
        Assert.assertEquals(namedPoint.getName(), "Absent");
        namedPoint.setName("Ildar");
        namedPoint.reset();
        Assert.assertEquals(namedPoint.getName(), "Absent");
    }

    @Test
    public static void testToString() {
        NamedPoint namedPointOne = new NamedPoint();
        Assert.assertEquals(namedPointOne.toString(), "Origin:[0.0,0.0,0.0]");
        NamedPoint namedPointTwo = new NamedPoint(1, 2, 3);
        Assert.assertEquals(namedPointTwo.toString(), "[1.0,2.0,3.0]");
        NamedPoint namedPointThree = new NamedPoint(3, 4.6, -2.1, "Ildar");
        Assert.assertEquals(namedPointThree.toString(), "Ildar:[3.0,4.6,-2.1]");
    }

}