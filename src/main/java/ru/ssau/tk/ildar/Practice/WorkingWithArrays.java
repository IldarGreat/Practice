package ru.ssau.tk.ildar.Practice;

public class WorkingWithArrays {

    public static void showingTheResult(double[] array) {
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
        if (number < 1) return 0;
        if (number == 1) return 1;
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
        if (a == 0) return new double[]{-c / b};
        if (b * b == 4 * a * c) return new double[]{-b / (2 * a)};
        if (b * b > 4 * a * c) return new double[]{-b / (2 * a), b / (2 * a)};
        return new double[]{};
    }

    public static double[] returningArrayWithoutNumberDividedByThree(int dimension){
        double[] array = new double[dimension];
        double number=0;
        for (int element=0;element<dimension;element++,number++){
            if((number%3==0)&&(number!=0)) array[element]=++number;
            else array[element]=number;
        }
        return array;
    }

    public static double[] returningArrayFilledArithmeticProgression(int dimension,double firstElement,double difference){
        double[] array = new double[dimension];
        array[0]=firstElement;
        for(int element=1;element<dimension;element++){
            array[element]=array[element-1]+difference;
        }
        return array;
    }

    public static double[] returningArrayFilledGeometricProgression(int dimension,double firstElement,double denominator){
        double[] array = new double[dimension];
        array[0]=firstElement;
        for(int element=1;element<dimension;element++,firstElement++){
            array[element]=array[element-1]*denominator;
        }
        return array;
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
        showingTheResult(returningArrayFilledArithmeticProgression(10,3,3.5));
        System.out.println();
        showingTheResult(returningArrayFilledGeometricProgression(10,50,0.5));
    }
}
