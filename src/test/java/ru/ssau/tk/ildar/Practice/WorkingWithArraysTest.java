package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import static ru.ssau.tk.ildar.Practice.WorkingWithArrays.returningArrayOfAGivenDimension;

public class WorkingWithArraysTest {

    @Test
    public static void testReturningArrayOfAGivenDimension(){
        Assert.assertEquals(returningArrayOfAGivenDimension(5).length,5);
        Assert.assertEquals(returningArrayOfAGivenDimension(9).length,9);
    }

}