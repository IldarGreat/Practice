package ru.ssau.tk.ildar.Practice.functions;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SqrtOperationTest {

    public static final double DELTA = 0.0001;
    SqrtOperation sqrtObject = new SqrtOperation();

    @Test
    public void testApply()
    {
        Assert.assertEquals(sqrtObject.apply(256),16.0,DELTA);
        Assert.assertEquals(sqrtObject.apply(5),2.2360,DELTA);
        Assert.assertEquals(sqrtObject.apply(-23.4),Double.NaN);
        Assert.assertEquals(sqrtObject.apply(Double.POSITIVE_INFINITY),Double.POSITIVE_INFINITY);
        Assert.assertEquals(sqrtObject.apply(Double.NEGATIVE_INFINITY),Double.NaN);
        Assert.assertEquals(sqrtObject.apply(Double.NaN),Double.NaN);
    }

    @Test
    public void testApplyTriple()
    {
        Assert.assertEquals(sqrtObject.applyTriple(256),2,DELTA);
        Assert.assertEquals(sqrtObject.apply(5),2.2360,DELTA);
        Assert.assertEquals(sqrtObject.apply(13.0/7.0),1.3627,DELTA);
        Assert.assertEquals(sqrtObject.apply(-321),Double.NaN);
        Assert.assertEquals(sqrtObject.applyTriple(Double.POSITIVE_INFINITY),Double.POSITIVE_INFINITY);
        Assert.assertEquals(sqrtObject.applyTriple(Double.NEGATIVE_INFINITY),Double.NaN);
        Assert.assertEquals(sqrtObject.applyTriple(Double.NaN),Double.NaN);
    }

}