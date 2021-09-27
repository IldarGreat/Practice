package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import static ru.ssau.tk.ildar.Practice.WorkingWithArrays.*;


public class WorkingWithArraysTest {

    @Test
    public static void testReturningArrayOfAGivenDimension() {
        Assert.assertEquals(returningArrayOfAGivenDimension(5).length, 5);
        Assert.assertEquals(returningArrayOfAGivenDimension(9).length, 9);
    }

    @Test
    public static void testReturningArrayFilledWithOnes() {
        int[] array = returningArrayFilledWithOnes(10);
        Assert.assertEquals(array[0], 2);
        Assert.assertEquals(array[9], 2);
        for (int element = 1; element < 8; element++) {
            Assert.assertEquals(array[element], 1);
        }
    }

    @Test
    public static void testReturningArrayWithOddNumbers() {
        int[] array = returningArrayWithOddNumbers(10);
        for (int element=0;element<10;element++) {
            Assert.assertEquals(array[element], element*2+1);
        }
    }

}