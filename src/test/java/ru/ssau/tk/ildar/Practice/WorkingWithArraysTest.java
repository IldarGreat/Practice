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

    @Test
    public static void testReturningArrayWithReverseEvenNumbers(){
        int[] array=returningArrayWithReverseEvenNumbers(10);
        for(int element=0;element<10;element++){
            Assert.assertEquals(array[element],element*2+2);
        }
    }

    @Test
    public static void testfibonacciNumbers(){
        Assert.assertEquals(fibonacciNumbers(1),1);
        Assert.assertEquals(fibonacciNumbers(2),1);
        Assert.assertEquals(fibonacciNumbers(3),2);
        Assert.assertEquals(fibonacciNumbers(4),3);
        Assert.assertEquals(fibonacciNumbers(5),5);
        Assert.assertEquals(fibonacciNumbers(6),8);
        Assert.assertEquals(fibonacciNumbers(7),13);
        Assert.assertEquals(fibonacciNumbers(8),21);
        Assert.assertEquals(fibonacciNumbers(9),34);
    }

    @Test
    public static void testReturningArrayWithFibonacciNumbers(){
        int[] array =returningArrayWithFibonacciNumbers(8);
        for(int element=0;element<7;element++){
            Assert.assertEquals(array[element],fibonacciNumbers(element));
        }
    }

    @Test
    public static void testReturningArrayFillerWithSquareIndex(){
        int[] array = returningArrayFillerWithSquareIndex(10);
        for(int element=0;element<10;element++){
            Assert.assertEquals(array[element],element*element);
        }
    }
}