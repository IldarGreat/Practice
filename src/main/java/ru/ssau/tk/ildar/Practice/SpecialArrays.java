package ru.ssau.tk.ildar.Practice;

import java.util.ArrayList;
import java.util.Collections;

public class SpecialArrays {

    public static void showingTheResult(double[] array) {
        for (double i : array) {
            System.out.println(i);
        }
    }

    public static void showingTheResult(ArrayList<Integer> array) {
        for (double i : array) {
            System.out.println(i);
        }
    }

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

    public static int numberOfEvenNumbers(double[] array){
        int evenNumber=0;
        for (double v : array) {
            if (v % 2 == 0) evenNumber++;
        }
        return evenNumber;
    }

    public static Object maxNumber(int[] array){
        if(array.length==0) return null;
        int maxNumber=array[0];
        for (int i : array) {
            if (i > maxNumber) maxNumber = i;
        }
        return maxNumber;
    }

    public static double sumElementsInEvenIndex(double[] array){
        double sumElementInEvenIndex=0;
        for (int element=0;element<array.length;element++){
            if(element%2==0) sumElementInEvenIndex+=array[element];
        }
        return sumElementInEvenIndex;
    }


    public static void main(String[] args) {
        showingTheResult(returningArrayOfAGivenDimension(5));
        System.out.println();
        showingTheResult(returningArrayFilledWithOnes(7));
        System.out.println();
        showingTheResult(returningArrayWithOddNumbers(5));
        System.out.println();
        showingTheResult(returningArrayWithReverseEvenNumbers(10));
        System.out.println();
        showingTheResult(returningArrayWithFibonacciNumbers(8));
        System.out.println();
        showingTheResult(returningArrayFillerWithSquareIndex(10));
        System.out.println();
        showingTheResult(returningArrayFilledWithEquationSolution(0, 5, 2));
        System.out.println();
        showingTheResult(returningArrayWithoutNumberDividedByThree(10));
        System.out.println();
        showingTheResult(returningArrayFilledArithmeticProgression(10, 3, 3.5));
        System.out.println();
        showingTheResult(returningArrayFilledGeometricProgression(10, 50, 0.5));
        System.out.println();
        showingTheResult(returningArrayWithIntegerDivisors(64));
        System.out.println();
        showingTheResult(returningArrayWithPrimeNumbers(55));
        System.out.println();
        double[] arrayReverseSign = returningArrayFilledWithOnes(6);
        numberSignSubstitution(arrayReverseSign);
        showingTheResult(arrayReverseSign);
        System.out.println();
        showingTheResult(returningSymmetricArray(11));
        System.out.println();
        System.out.println(numberInTheArray(arrayReverseSign, 1.0));
        System.out.println(nullInInteger(new Integer[]{5, 3, null}));
        System.out.println(numberOfEvenNumbers(new double[] {3,4,5,6}));
        System.out.println(maxNumber(new int[] {-1,56,-39,23,68,0}));
        System.out.println(sumElementsInEvenIndex(new double[]{1,2,3,4,5,6,7}));
    }
}
