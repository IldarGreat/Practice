package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TangentOperationTest {
    final static double someNumber =0;
    public static final double POSITIVE_INFINITY = 1.0 / 0.0; // Ввожу плюс бесконечность
    public static final double NEGATIVE_INFINITY = -1.0 / 0.0; // Ввожу минус бесконечность

    TangentOperation justTest = new TangentOperation();

    @Test
    public void testApply(){
        Assert.assertEquals(justTest.apply(someNumber),0);  // Тангенс нуля ноль
        Assert.assertEquals(justTest.apply(POSITIVE_INFINITY),POSITIVE_INFINITY-POSITIVE_INFINITY);  // Выведет NaN
        Assert.assertEquals(justTest.apply(NEGATIVE_INFINITY),POSITIVE_INFINITY-POSITIVE_INFINITY);  //
        Assert.assertEquals(justTest.apply(POSITIVE_INFINITY-POSITIVE_INFINITY),POSITIVE_INFINITY-POSITIVE_INFINITY); //
    }

    @Test
    public void testApplyTriple(){
        Assert.assertEquals(justTest.applyTriple(someNumber),0);  // Каждый раз возвращаем 0
        Assert.assertEquals(justTest.applyTriple(POSITIVE_INFINITY),POSITIVE_INFINITY-POSITIVE_INFINITY);  // Очевидно
        Assert.assertEquals(justTest.applyTriple(NEGATIVE_INFINITY),POSITIVE_INFINITY-POSITIVE_INFINITY);  // Очевидно
        Assert.assertEquals(justTest.applyTriple(POSITIVE_INFINITY-POSITIVE_INFINITY),POSITIVE_INFINITY-POSITIVE_INFINITY);
    }
}