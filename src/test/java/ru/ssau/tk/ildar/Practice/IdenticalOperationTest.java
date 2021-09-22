package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class IdenticalOperationTest {

    IdenticalOperation justTest = new IdenticalOperation();

    @Test
    public void testApply()
    {
        Assert.assertEquals(justTest.apply(256),256.0);
        Assert.assertEquals(justTest.apply(Double.NEGATIVE_INFINITY),Double.NEGATIVE_INFINITY);
        Assert.assertEquals(justTest.apply(Double.POSITIVE_INFINITY),Double.POSITIVE_INFINITY);
        Assert.assertEquals(justTest.apply(Double.NaN),Double.NaN);
    }

    @Test
    public void testApplyTriple()
    {
        Assert.assertEquals(justTest.applyTriple(256),256.0);
        Assert.assertEquals(justTest.applyTriple(Double.NEGATIVE_INFINITY),Double.NEGATIVE_INFINITY);
        Assert.assertEquals(justTest.applyTriple(Double.POSITIVE_INFINITY),Double.POSITIVE_INFINITY);
        Assert.assertEquals(justTest.applyTriple(Double.NaN),Double.NaN);
    }

}