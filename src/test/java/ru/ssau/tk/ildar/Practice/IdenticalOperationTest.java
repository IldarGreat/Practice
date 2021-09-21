package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IdenticalOperationTest {
    final static double someNumber =256;
    public static final double POSITIVE_INFINITY = 1.0 / 0.0; // Ввожу плюс бесконечность
    public static final double NEGATIVE_INFINITY = -1.0 / 0.0; // Ввожу минус бесконечность

    IdenticalOperation justTest = new IdenticalOperation();

    @Test
    public void testApply()
    {
        Assert.assertEquals(justTest.apply(someNumber),256);  // Просто проверим apply должно возвратить это же число
        Assert.assertEquals(justTest.apply(POSITIVE_INFINITY),POSITIVE_INFINITY);  // Возвратит бесконечность
        Assert.assertEquals(justTest.apply(NEGATIVE_INFINITY),NEGATIVE_INFINITY);  // Возвратит минус бесконечность
        Assert.assertEquals(justTest.apply(POSITIVE_INFINITY-POSITIVE_INFINITY),POSITIVE_INFINITY-POSITIVE_INFINITY);
    }

    @Test
    public void testApplyTriple()
    {
        Assert.assertEquals(justTest.applyTriple(someNumber),256);  // Каждый раз возвращаем 256
        Assert.assertEquals(justTest.applyTriple(POSITIVE_INFINITY),POSITIVE_INFINITY);  // Очевидно
        Assert.assertEquals(justTest.applyTriple(NEGATIVE_INFINITY),NEGATIVE_INFINITY);  // Очевидно
        Assert.assertEquals(justTest.applyTriple(POSITIVE_INFINITY-POSITIVE_INFINITY),POSITIVE_INFINITY-POSITIVE_INFINITY); // О-о-очевидноо
    }

}