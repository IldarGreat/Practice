package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TangentOperationTest {

    public static final double DELTA = 0.0001;

    TangentOperation tangentObject = new TangentOperation();

    @Test
    public void testApply()
    {
        Assert.assertEquals(tangentObject.apply(256),25.1115,DELTA);
        Assert.assertEquals(tangentObject.apply(5.0/7.0),0.8670,DELTA);
        Assert.assertEquals(tangentObject.apply(-23.4),-6.1208,DELTA);
        Assert.assertEquals(tangentObject.apply(Double.POSITIVE_INFINITY),Double.NaN);
        Assert.assertEquals(tangentObject.apply(Double.NEGATIVE_INFINITY),Double.NaN);
        Assert.assertEquals(tangentObject.apply(Double.NaN),Double.NaN);
    }

    @Test
    public void testApplyTriple()
    {
        Assert.assertEquals(tangentObject.applyTriple(256),-0.0211,DELTA);
        Assert.assertEquals(tangentObject.apply(5),-3.3805,DELTA);
        Assert.assertEquals(tangentObject.apply(13.0/7.0),-3.3962,DELTA);
        Assert.assertEquals(tangentObject.applyTriple(Double.POSITIVE_INFINITY),Double.NaN);
        Assert.assertEquals(tangentObject.applyTriple(Double.NEGATIVE_INFINITY),Double.NaN);
        Assert.assertEquals(tangentObject.applyTriple(Double.NaN),Double.NaN);
    }
}