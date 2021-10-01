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
        double[] array = returningArrayFilledWithOnes(10);
        Assert.assertEquals(array[0], 2.0);
        Assert.assertEquals(array[9], 2.0);
        for (int element = 1; element < 8; element++) {
            Assert.assertEquals(array[element], 1.0);
        }
    }

    @Test
    public static void testReturningArrayWithOddNumbers() {
        double[] array = returningArrayWithOddNumbers(10);
        for (int element = 0; element < 10; element++) {
            Assert.assertEquals(array[element], (double) element * 2 + 1);
        }
    }

    @Test
    public static void testReturningArrayWithReverseEvenNumbers() {
        double[] array = returningArrayWithReverseEvenNumbers(10);
        for (int element = 0; element < 10; element++) {
            Assert.assertEquals(array[element], (double) element * 2 + 2);
        }
    }

    @Test
    public static void testfibonacciNumbers() {
        Assert.assertEquals(fibonacciNumbers(1), 1);
        Assert.assertEquals(fibonacciNumbers(2), 1);
        Assert.assertEquals(fibonacciNumbers(3), 2);
        Assert.assertEquals(fibonacciNumbers(4), 3);
        Assert.assertEquals(fibonacciNumbers(5), 5);
        Assert.assertEquals(fibonacciNumbers(6), 8);
        Assert.assertEquals(fibonacciNumbers(7), 13);
        Assert.assertEquals(fibonacciNumbers(8), 21);
        Assert.assertEquals(fibonacciNumbers(9), 34);
    }

    @Test
    public static void testReturningArrayWithFibonacciNumbers() {
        double[] array = returningArrayWithFibonacciNumbers(8);
        for (int element = 0; element < 7; element++) {
            Assert.assertEquals(array[element], (double) fibonacciNumbers(element));
        }
    }

    @Test
    public static void testReturningArrayFillerWithSquareIndex() {
        double[] array = returningArrayFillerWithSquareIndex(10);
        for (int element = 0; element < 10; element++) {
            Assert.assertEquals(array[element], (double) element * element);
        }
    }

    @Test
    public static void testReturningArrayFilledWithEquationSolution() {
        double[] arrayWithTwoSolution = returningArrayFilledWithEquationSolution(2, 6, 3);
        Assert.assertEquals(arrayWithTwoSolution[0], -1.5);
        Assert.assertEquals(arrayWithTwoSolution[1], 1.5);
        double[] arrayWithOneSolution = returningArrayFilledWithEquationSolution(2, 4, 2);
        Assert.assertEquals(arrayWithOneSolution[0], -1.0);
    }

    @Test
    public static void testReturningArrayWithoutNumberDividedByThree(){
        double[] arrayWithoutThrees = returningArrayWithoutNumberDividedByThree(10);
        Assert.assertEquals(arrayWithoutThrees[3],4.0);
        Assert.assertEquals(arrayWithoutThrees[6],8.0);
        Assert.assertEquals(arrayWithoutThrees[9],13.0);
    }

    @Test
    public static void testReturningArrayFilledArithmeticProgression(){
        double[] arrayWithArithmeticProgression=returningArrayFilledArithmeticProgression(15,6);
        Assert.assertEquals(arrayWithArithmeticProgression[1],6.0);
        Assert.assertEquals(arrayWithArithmeticProgression[7],42.0);
        Assert.assertEquals(arrayWithArithmeticProgression[14],84.0);
    }
}