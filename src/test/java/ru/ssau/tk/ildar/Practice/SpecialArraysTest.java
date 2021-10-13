package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Objects;

import static ru.ssau.tk.ildar.Practice.SpecialArrays.*;


public class SpecialArraysTest {
    public static final double DELTA = 0.0001;

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
        Assert.assertEquals(arrayWithTwoSolution[0], -6.8660, DELTA);
        Assert.assertEquals(arrayWithTwoSolution[1], -5.1339, DELTA);
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
        Assert.assertEquals(arrayWithIntegerDivisors.get(0), Integer.valueOf(1));
        Assert.assertEquals(arrayWithIntegerDivisors.get(1), Integer.valueOf(5));
        ArrayList<Integer> arrayWithIntegerDivisorsTwo = returningArrayWithIntegerDivisors(-155);
        Assert.assertEquals(arrayWithIntegerDivisorsTwo.get(1), Integer.valueOf(5));
    }

    @Test
    public static void testIsSimple() {
        Assert.assertFalse(isSimple(21));
        Assert.assertFalse(isSimple(105));
        Assert.assertFalse(isSimple(91));
        Assert.assertTrue(isSimple(89));
        Assert.assertTrue(isSimple(97));
        Assert.assertTrue(isSimple(103));
    }

    @Test
    public static void testReturningArrayWithPrimeNumbers() {
        ArrayList<Integer> arrayWithPrimeNumbers = returningArrayWithPrimeNumbers(55);
        Assert.assertEquals(arrayWithPrimeNumbers.get(3), Integer.valueOf(7));
        Assert.assertEquals(arrayWithPrimeNumbers.get(5), Integer.valueOf(13));
    }

    @Test
    public static void numberSignSubstitution() {
        double[] arrayWithoutThrees = returningArrayWithoutNumberDividedByThree(10);
        SpecialArrays.numberSignSubstitution(arrayWithoutThrees);
        Assert.assertEquals(arrayWithoutThrees[3], -4.0);
        Assert.assertEquals(arrayWithoutThrees[6], -8.0);
        Assert.assertEquals(arrayWithoutThrees[9], -13.0);
    }

    @Test
    public static void testReturningSymmetricArray() {
        double[] symmetricArray = returningSymmetricArray(21);
        for (int element = 0; element < symmetricArray.length; element++) {
            symmetricArray[element] = symmetricArray[symmetricArray.length - element - 1];
        }
    }

    @Test
    public static void testNumberInTheArray() {
        double[] array = new double[]{4.5, Double.NaN, 45.0 / 7.0, Double.POSITIVE_INFINITY};
        Assert.assertTrue(numberInTheArray(array, 4.5));
        Assert.assertTrue(numberInTheArray(array, 45.0 / 7.0));
        Assert.assertTrue(numberInTheArray(array, Double.POSITIVE_INFINITY));
        Assert.assertFalse(numberInTheArray(array, 4.6));
    }

    @Test
    public static void testNullInInteger() {
        Assert.assertTrue(nullInInteger(new Integer[]{2, 3, null}));
        Assert.assertFalse(nullInInteger(new Integer[]{2, 3, 6, 19}));
    }

    @Test
    public static void testNumberOfEvenNumbers() {
        double[] array = new double[]{1, 2, 3, 4, 5, 6, 7, 10, 15, 16};
        double[] infinityArray = new double[]{Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
        Assert.assertEquals(numberOfEvenNumbers(array), 5);
        Assert.assertEquals(numberOfEvenNumbers(infinityArray), 0);
    }

    @Test
    public static void testMaxNumber() {
        Assert.assertEquals(maxNumber(new int[]{34, -2, 0, 324}), 324);
        Assert.assertEquals(maxNumber(new int[]{Integer.MAX_VALUE, 343432, -23}), Integer.MAX_VALUE);
    }

    @Test
    public static void testSumElementsInEvenIndex() {
        Assert.assertEquals(sumElementsInEvenIndex(new double[]{321, 432, 67, -31, -321, 32, -67}), 0.0);
        Assert.assertEquals(sumElementsInEvenIndex(new double[]{Double.POSITIVE_INFINITY, 23, 12}), Double.POSITIVE_INFINITY);
        Assert.assertEquals(sumElementsInEvenIndex(new double[]{Double.POSITIVE_INFINITY, 0, Double.NEGATIVE_INFINITY}), Double.NaN);
        Assert.assertEquals(sumElementsInEvenIndex(new double[]{}), 0.0);
    }

    @Test
    public static void testIsNumbersDivisibleByTheFirstElementAreMore() {
        Assert.assertTrue(isNumbersDivisibleByTheFirstElementAreMore(new int[]{2, 64, 128, 12, 9, 6, 3}));
    }

    @Test
    public static void testIsArrayEmpty() {
        int[] array = new int[10];
        Assert.assertTrue(isArrayEmpty(new int[]{}));
        Assert.assertTrue(isArrayEmpty(array));
    }

    @Test
    public static void testMostCommonElement() {
        Assert.assertEquals(mostCommonElement(new double[]{1, 2, 1, 2, 1, 2}), 1.0);
        Assert.assertEquals(mostCommonElement(new double[]{1, 2, 1, 2, 1, 2, 3, 3, 3, 3, 3}), 3.0);
        Assert.assertNull(mostCommonElement(new double[]{1, 2, 3, 4, 5}));
    }

    @Test
    public static void testIndexOfNumber() {
        Assert.assertEquals((indexOfNumber(new double[]{3, 5, 7, 9}, 9.0)), 3);
        Assert.assertEquals((indexOfNumber(new double[]{3, 5, 7, 9}, 10)), -1);
    }

    @Test
    public static void testSwappingMinAndMax() {
        double[] array = new double[]{5, 7, 1, 8, 3, 6, 0, 2};
        swappingMinAndMax(array);
        Assert.assertEquals(array[3], 0.0);
        Assert.assertEquals(array[6], 8.0);
    }

    @Test
    public static void testBitwiseNegation() {
        int[] array = new int[]{10, -2, 0, 3, -11};
        bitwiseNegation(array);
        Assert.assertEquals(array[0], -11);
        Assert.assertEquals(array[1], 1);
        Assert.assertEquals(array[2], -1);
        Assert.assertEquals(array[3], -4);
        Assert.assertEquals(array[4], 10);
        bitwiseNegation(array);
        Assert.assertEquals(array[0], 10);
        Assert.assertEquals(array[1], -2);
        Assert.assertEquals(array[2], 0);
        Assert.assertEquals(array[3], 3);
        Assert.assertEquals(array[4], -11);
    }

    @Test
    public static void testReturningBitwiseNegationArray() {
        int[] array = new int[]{10, -11, 0};
        Assert.assertEquals(array[0], 10);
        Assert.assertEquals(array[1], -11);
        Assert.assertEquals(array[2], 0);
        int[] secondArray = returningBitwiseNegationArray(array);
        Assert.assertEquals(secondArray[0], -11);
        Assert.assertEquals(secondArray[1], 10);
        Assert.assertEquals(secondArray[2], -1);
        int[] ThirdArray = returningBitwiseNegationArray(secondArray);
        Assert.assertEquals(ThirdArray[0], 10);
        Assert.assertEquals(ThirdArray[1], -11);
        Assert.assertEquals(ThirdArray[2], 0);
    }

    @Test
    public static void testReturningSumElementsOfArray() {
        int[] array = returningSumElementsOfArray(new int[]{5, 8, 9, 10, 11, 20});
        Assert.assertEquals(array[0], 13);
        Assert.assertEquals(array[1], 19);
        Assert.assertEquals(array[2], 31);
        int[] arrayTwo = returningSumElementsOfArray(new int[]{5, 8, 9, 10, 11});
        Assert.assertEquals(arrayTwo[0], 13);
        Assert.assertEquals(arrayTwo[1], 19);
        Assert.assertEquals(arrayTwo[2], 11);
    }

    @Test
    public static void testReturnBooleanArray() {
        boolean[] booleanArray = returnBooleanArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        Assert.assertTrue(booleanArray[0]);
        Assert.assertFalse(booleanArray[1]);
        Assert.assertTrue(booleanArray[2]);
        Assert.assertFalse(booleanArray[3]);
        Assert.assertTrue(booleanArray[4]);
        Assert.assertFalse(booleanArray[5]);
        Assert.assertTrue(booleanArray[6]);
    }

    @Test
    public static void testArrayLongToIntAndLongFromTwoInt() {
        Assert.assertEquals(longFromTwoInt(arrayLongToInt(53219359L)), 53219359L);
        Assert.assertEquals(longFromTwoInt(arrayLongToInt(53432423423L)), 53432423423L);
        Assert.assertEquals(longFromTwoInt(arrayLongToInt(23536359L)), 23536359L);
    }

    @Test
    public static void testReturningSpecialArray() {
        Assert.assertEquals(returningSpecialArray(10, 7), new double[]{4, 5, 6, 7, 8, 9, 10, 1, 2, 3});
    }

    @Test
    public static void testReturningDoubleArray() {
        int[][] array = returningDoubleArray(3);
        Assert.assertEquals(Objects.requireNonNull(array)[0], new int[]{1, 2, 3});
        Assert.assertEquals(array[1], new int[]{4, 5});
        Assert.assertEquals(array[2], new int[]{6});
    }

    @Test
    public static void testSortWithoutNaN() {
        double[] arrayOne = new double[]{-32.2, 0.0, -123.2, 53.7, 3.0 / 7.0};
        sortWithoutNaN(arrayOne);
        Assert.assertEquals(arrayOne[0], -123.2);
        Assert.assertEquals(arrayOne[1], -32.2);
        Assert.assertEquals(arrayOne[2], 0.0);
        Assert.assertEquals(arrayOne[3], 3.0 / 7.0, DELTA);
        Assert.assertEquals(arrayOne[4], 53.7);

        double[] arrayTwo = new double[]{-32.2, 0.0, -123.2, 53.7, 3.0 / 7.0, Double.NaN};
        sortWithoutNaN(arrayTwo);
        Assert.assertEquals(arrayTwo[0], -32.2);
        Assert.assertEquals(arrayTwo[1], 0.0);
        Assert.assertEquals(arrayTwo[2], -123.2);
        Assert.assertEquals(arrayTwo[3], 53.7);
        Assert.assertEquals(arrayTwo[4], 3.0 / 7.0, DELTA);
        Assert.assertEquals(arrayTwo[5], Double.NaN);
    }

    @Test
    public static void testPrintStringArray() {
        String[] array = new String[]{"One", "Two", "Three", "Four", "Five"};
        printStringArray(array);
    }

    @Test
    public static void testMultiplicationAllElements() {
        Assert.assertEquals(multiplicationAllElements(new double[]{3.0, 4.0, 7.0, 0, Double.NaN, Double.POSITIVE_INFINITY}), 84.0);
    }

    @Test
    public static void testMyToHexString() {
        myToHexString(new int[]{-4,2,7,9,2,5,-7});
    }
}