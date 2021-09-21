package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SqrtOperationTest {
    final static double someNumber =256;
    public static final double POSITIVE_INFINITY = 1.0 / 0.0; // Ввожу плюс бесконечность
    public static final double NEGATIVE_INFINITY = -1.0 / 0.0; // Ввожу минус бесконечность

    SqrtOperation justTest = new SqrtOperation();

    @Test
    public void testApply()
    {
        Assert.assertEquals(justTest.apply(someNumber),16);  // Просто проверим apply корень из 256 это 16
        Assert.assertEquals(justTest.apply(POSITIVE_INFINITY),POSITIVE_INFINITY);  // Корень из бесконечности это бесконечность
        Assert.assertEquals(justTest.apply(NEGATIVE_INFINITY),POSITIVE_INFINITY-POSITIVE_INFINITY);  // Корень из минус бесконечности должен быть Nan(POSITIVE_INFINITY-POSITIVE_INFINITY)
        Assert.assertEquals(justTest.apply(POSITIVE_INFINITY-POSITIVE_INFINITY),POSITIVE_INFINITY-POSITIVE_INFINITY); // Корень от NaN это Nan
    }

    @Test
    public void testApplyTriple()
    {
        Assert.assertEquals(justTest.applyTriple(someNumber),2);  // Корень из корня корня 256 это 2
        Assert.assertEquals(justTest.applyTriple(POSITIVE_INFINITY),POSITIVE_INFINITY);  // Корень из корня корня бесконечности это бесконечность
        Assert.assertEquals(justTest.applyTriple(NEGATIVE_INFINITY),POSITIVE_INFINITY-POSITIVE_INFINITY);  // Корень из корня корня минус бесконечности должен быть Nan(POSITIVE_INFINITY-POSITIVE_INFINITY)
        Assert.assertEquals(justTest.applyTriple(POSITIVE_INFINITY-POSITIVE_INFINITY),POSITIVE_INFINITY-POSITIVE_INFINITY);
    }

}