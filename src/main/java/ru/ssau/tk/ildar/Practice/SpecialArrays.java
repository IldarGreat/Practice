package ru.ssau.tk.ildar.Practice;

import java.util.ArrayList;
import java.util.Collections;

public class SpecialArrays {

    public static double[] returningArrayOfAGivenDimension(int dimension) {
        return new double[dimension];
    }

    public static double[] returningArrayFilledWithOnes(int dimension) {
        double[] array = new double[dimension];
        for (int i : new int[]{0, dimension - 1}) {
            array[i] = 2;
        }
        for (int element = 1; element < dimension - 1; element++) {
            array[element] = 1;
        }
        return array;
    }

    public static double[] returningArrayWithOddNumbers(int dimension) {
        double[] array = new double[dimension];
        for (int element = 0; element < dimension; element++) {
            array[element] = 2 * element + 1;
        }
        return array;
    }

    public static double[] returningArrayWithReverseEvenNumbers(int dimension) {
        double[] array = new double[dimension];
        for (int element = dimension - 1; element >= 0; element--) {
            array[element] = element * 2 + 2;
        }
        return array;
    }

    public static int fibonacciNumbers(int number) {
        if (number < 1) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return fibonacciNumbers(number - 1) + fibonacciNumbers(number - 2);
    }

    public static double[] returningArrayWithFibonacciNumbers(int dimension) {
        double[] array = new double[dimension];
        for (int element = 0; element < dimension; element++) {
            array[element] = fibonacciNumbers(element);
        }
        return array;
    }

    public static double[] returningArrayFillerWithSquareIndex(int dimension) {
        double[] array = new double[dimension];
        for (int element = 0; element < dimension; element++) {
            array[element] = element * element;
        }
        return array;
    }

    public static double[] returningArrayFilledWithEquationSolution(double a, double b, double c) {
        if (a == 0) {
            return new double[]{-c / b};
        }
        double discriminant = b * b - 4 * a * c;
        if (b * b == 4 * a * c) {
            return new double[]{-b / (2 * a)};
        }
        if (b * b > 4 * a * c) {
            return new double[]{-b - (Math.sqrt(discriminant)) / (2 * a), -b + (Math.sqrt(discriminant)) / (2 * a)};
        }
        return new double[]{};
    }

    public static double[] returningArrayWithoutNumberDividedByThree(int dimension) {
        double[] array = new double[dimension];
        double number = 0;
        for (int element = 0; element < dimension; element++, number++) {
            if ((number % 3 == 0) && (number != 0)) {
                array[element] = ++number;
            } else array[element] = number;
        }
        return array;
    }

    public static double[] returningArrayFilledArithmeticProgression(int dimension, double firstElement, double difference) {
        double[] array = new double[dimension];
        array[0] = firstElement;
        for (int element = 1; element < dimension; element++) {
            array[element] = array[element - 1] + difference;
        }
        return array;
    }

    public static double[] returningArrayFilledGeometricProgression(int dimension, double firstElement, double denominator) {
        double[] array = new double[dimension];
        array[0] = firstElement;
        for (int element = 1; element < dimension; element++, firstElement++) {
            array[element] = array[element - 1] * denominator;
        }
        return array;
    }

    public static ArrayList<Integer> returningArrayWithIntegerDivisors(int number) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int divider = (int) Math.sqrt(Math.abs(number)); divider > 0; divider--) {
            if (number % divider == 0) {
                array.add(divider);
            }
        }
        Collections.reverse(array);
        return array;
    }

    public static boolean isSimple(Integer number) {
        for (int divider = number - 1; divider > 1; divider--) {
            if (number % divider == 0) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> returningArrayWithPrimeNumbers(int number) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int primeNumber = number; primeNumber > 1; primeNumber--) {
            if (isSimple(primeNumber)) {
                array.add(primeNumber);
            }
        }
        Collections.reverse(array);
        return array;
    }

    public static void numberSignSubstitution(double[] array) {
        for (int element = 0; element < array.length; element++) {
            array[element] = -array[element];
        }
    }

    public static double[] returningSymmetricArray(int dimension) {
        double[] array = new double[dimension];
        for (int element = 0; element <= dimension / 2; element++) {
            array[element] = element + 1;
            array[dimension - element - 1] = array[element];
        }
        return array;
    }

    public static boolean numberInTheArray(double[] array, double number) {
        for (double v : array) {
            if (v == number) return true;
        }
        return false;
    }

    public static boolean nullInInteger(Integer[] integerArray) {
        for (Integer integer : integerArray) {
            if (integer == null) return true;
        }
        return false;
    }

    public static int numberOfEvenNumbers(double[] array) {
        int evenNumber = 0;
        for (double v : array) {
            if (v % 2 == 0) evenNumber++;
        }
        return evenNumber;
    }

    public static int maxNumber(int[] array) {
        if (array.length == 0) return 0;
        int maxNumber = array[0];
        for (int i : array) {
            if (i > maxNumber) maxNumber = i;
        }
        return maxNumber;
    }


    public static double sumElementsInEvenIndex(double[] array) {
        double sumElementInEvenIndex = 0;
        for (int element = 0; element < array.length; element++) {
            if (element % 2 == 0) {
                sumElementInEvenIndex += array[element];
            }
        }
        return sumElementInEvenIndex;
    }

    public static boolean isNumbersDivisibleByTheFirstElementAreMore(int[] array) {
        int divideByTheFirst = 0;
        int divideByTheLast = 0;
        for (int i : array) {
            if (i % array[0] == 0) {
                divideByTheFirst++;
            }
            if (i % array[array.length - 1] == 0) {
                divideByTheLast++;
            }
        }
        return divideByTheFirst > divideByTheLast;
    }

    public static boolean isArrayEmpty(int[] array) {
        if (array.length == 0) {
            return true;
        }
        for (int element = 1; element < array.length; element++) {
            if (array[element - 1] != array[element] || array[element] != 0) {
                return false;
            }
        }
        return true;
    }

    public static Object mostCommonElement(double[] array) {
        int[] coincidences = new int[array.length];

        for (int element = 0; element < array.length; element++) {
            for (int interiorElement = element + 1; interiorElement < array.length; interiorElement++) {
                if (array[element] == array[interiorElement]) {
                    coincidences[element]++;
                }
            }
        }
        if (isArrayEmpty(coincidences)) return null;
        for (int element = 0; element < coincidences.length; element++) {
            if (coincidences[element] == maxNumber(coincidences))
                return array[element];
        }
        return null;
    }

    public static int indexOfNumber(double[] array, double number) {
        for (int element = 0; element < array.length; element++) {
            if ((Math.abs(array[element] - number) < 0.0001)) {
                return element;
            }
        }
        return -1;
    }

    public static void swappingMinAndMax(double[] array) { // Не доделано!
        if(array.length==0){
            return;
        }
        double min=array[0];
        double max=array[0];
        double helper;
        int indexMin;
        int indexMax;
        for (double v : array) {
            if (min > v) {
                min = v;
            }
            if (max < v) {
                max = v;
            }
        }
        indexMin=indexOfNumber(array,min);
        indexMax=indexOfNumber(array,max);
        helper=array[indexMax];
        array[indexMax]=array[indexMin];
        array[indexMin]=helper;
    }

    public static void bitwiseNegation(int[] array) {
        for (int element = 0; element < array.length; element++) {
            array[element] = ~array[element];
        }
    }

    public static int[] returningBitwiseNegationArray(int[] array) {
        bitwiseNegation(array);
        return array;
    }

    public static int[] returningSumElementsOfArray(int[] array) {
        int lengthNewArray;
        if (array.length % 2 == 0) {
            lengthNewArray = array.length / 2;
            int[] newArray = new int[lengthNewArray];
            for (int element = 0; element < newArray.length; element++) {
                newArray[element] = array[element * 2] + array[element * 2 + 1];
            }
            return newArray;
        }
        lengthNewArray = array.length / 2 + 1;
        int[] newArray = new int[lengthNewArray];
        for (int element = 0; element < newArray.length - 1; element++) {
            newArray[element] = array[element * 2] + array[element * 2 + 1];
        }
        newArray[lengthNewArray - 1] = array[array.length - 1];
        return newArray;
    }

    public static boolean[] returnBooleanArray(int[] intArray) {
        boolean[] booleanArray = new boolean[intArray.length];
        for (int element = 0; element < intArray.length; element++) {
            booleanArray[element] = element % 2 == 0;
        }
        return booleanArray;
    }

    public static int[] arrayLongToInt(long number) {
        return new int[]{(int) (number >>> 32), (int) number};
    }

    public static long longFromTwoInt(int[] twoNumbers){
        return ((long) twoNumbers[0] <<32) | twoNumbers[1];
    }
}
