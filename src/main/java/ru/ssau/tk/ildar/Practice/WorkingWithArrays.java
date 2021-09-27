package ru.ssau.tk.ildar.Practice;

public class WorkingWithArrays {

    public static void showingTheResult(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static int[] returningArrayOfAGivenDimension(int dimension) {
        return new int[dimension];
    }

    public static int[] returningArrayFilledWithOnes(int dimension) {
        int[] array = new int[dimension];
        for (int i : new int[]{0, dimension - 1}) {
            array[i] = 2;
        }
        for (int element = 1; element < dimension - 1; element++) {
            array[element] = 1;
        }
        return array;
    }

    public static int[] returningArrayWithOddNumbers(int dimension) {
        int[] array = new int[dimension];
        for (int element = 0; element < dimension; element++) {
            array[element] = 2 * element + 1;
        }
        return array;
    }

    public static void main(String[] args) {
        showingTheResult(returningArrayOfAGivenDimension(5));
        System.out.println();
        showingTheResult(returningArrayFilledWithOnes(7));
        System.out.println();
        showingTheResult(returningArrayWithOddNumbers(5));
    }
}
