package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

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
    public static void testReturningArrayWithoutNumberDividedByThree() {
        double[] arrayWithoutThrees = returningArrayWithoutNumberDividedByThree(10);
        Assert.assertEquals(arrayWithoutThrees[3], 4.0);
        Assert.assertEquals(arrayWithoutThrees[6], 8.0);
        Assert.assertEquals(arrayWithoutThrees[9], 13.0);
    }

    @Test
    public static void testReturningArrayFilledArithmeticProgression() {
        double[] arrayWithArithmeticProgression = returningArrayFilledArithmeticProgression(15, 3.0, 6);
        Assert.assertEquals(arrayWithArithmeticProgression[5], 33.0);
        double[] arrayWithArithmeticProgressionTwo = returningArrayFilledArithmeticProgression(15, 3.0, -3.7);
        Assert.assertEquals(arrayWithArithmeticProgressionTwo[7], -22.9);
    }

    @Test
    public static void testReturningArrayFilledGeometricProgression() {
        double[] arrayWithArithmeticProgression = returningArrayFilledGeometricProgression(5, 7.2, -6.0 / 7.0);
        Assert.assertEquals(arrayWithArithmeticProgression[0], 7.2);
        double[] arrayWithArithmeticProgressionTwo = returningArrayFilledGeometricProgression(5, 7.2, Double.POSITIVE_INFINITY);
        Assert.assertEquals(arrayWithArithmeticProgressionTwo[1], Double.POSITIVE_INFINITY);
    }

    @Test
    public static void testReturningArrayWithIntegerDivisors() {
        ArrayList<Integer> arrayWithIntegerDivisors = returningArrayWithIntegerDivisors(155);
        Assert.assertEquals(arrayWithIntegerDivisors.get(0), Integer.valueOf(5));
        Assert.assertEquals(arrayWithIntegerDivisors.get(1), Integer.valueOf(1));
    }
}