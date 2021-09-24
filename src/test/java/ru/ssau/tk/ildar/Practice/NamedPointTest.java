package ru.ssau.tk.ildar.Practice;

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
    public void testReset(){
        NamedPoint namedPoint = new NamedPoint();
        namedPoint.reset();
        Assert.assertEquals(namedPoint.getName(), "Absent");
        namedPoint.setName("Ildar");
        namedPoint.reset();
        Assert.assertEquals(namedPoint.getName(), "Absent");
    }

}