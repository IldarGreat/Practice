package ru.ssau.tk.ildar.Practice;

public class WorkingWithArrays {

    public static int[] returningArrayOfAGivenDimension(int dimension) {
        return new int[dimension];
    }

    public static void main(String[] args) {
        returningArrayOfAGivenDimension(5)[0] = 0;
    }
}
