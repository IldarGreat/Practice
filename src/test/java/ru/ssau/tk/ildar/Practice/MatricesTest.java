package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import static ru.ssau.tk.ildar.Practice.Matrices.*;

public class MatricesTest {
    public static final double DELTA = 0.0001;

    @Test
    public static void testSum() {
        Matrix matrixOne = new Matrix(2, 3);
        Matrix matrixTwo = new Matrix(2, 3);

        matrixOne.setAt(0, 0, 50);
        matrixOne.setAt(0, 1, 32);  /* 50 23 */
        matrixOne.setAt(0, 2, 47);  /* 32 12 */
        matrixOne.setAt(1, 0, 23);  /* 47 67 */
        matrixOne.setAt(1, 1, 12);
        matrixOne.setAt(1, 2, 67);

        matrixTwo.setAt(0, 0, -23);
        matrixTwo.setAt(0, 1, 89);  /* -23  45 */
        matrixTwo.setAt(0, 2, -12); /*  89 -13 */
        matrixTwo.setAt(1, 0, 45);  /* -12  11 */
        matrixTwo.setAt(1, 1, -13);
        matrixTwo.setAt(1, 2, 11);

        Matrix newMatrix = sum(matrixOne, matrixTwo);
        Assert.assertEquals(newMatrix.getAt(0, 0), 27.0);
        Assert.assertEquals(newMatrix.getAt(0, 1), 121.0);
        Assert.assertEquals(newMatrix.getAt(0, 2), 35.0);
        Assert.assertEquals(newMatrix.getAt(1, 0), 68.0);
        Assert.assertEquals(newMatrix.getAt(1, 1), -1.0);
        Assert.assertEquals(newMatrix.getAt(1, 2), 78.0);

        Assert.assertThrows(IncompatibleDimensionsException.class, () -> sum(new Matrix(1, 2), new Matrix(2, 3)));

    }

    @Test
    public static void testMultiplicationByANumber() {
        Matrix matrix = new Matrix(2, 3);
        matrix.setAt(0, 0, 50);
        matrix.setAt(0, 1, 32); /* 50 23 */
        matrix.setAt(0, 2, 47); /* 32 12 */
        matrix.setAt(1, 0, 23); /* 47 67 */
        matrix.setAt(1, 1, 12);
        matrix.setAt(1, 2, 67);

        Matrix newMatrix = multiplicationByANumber(matrix, 1.0 / 3.0);
        Assert.assertEquals(newMatrix.getAt(0, 0), 16.6666, DELTA);
        Assert.assertEquals(newMatrix.getAt(0, 1), 10.6666, DELTA);
        Assert.assertEquals(newMatrix.getAt(0, 2), 15.6666, DELTA);
        Assert.assertEquals(newMatrix.getAt(1, 0), 7.6666, DELTA);
        Assert.assertEquals(newMatrix.getAt(1, 1), 4.0, DELTA);
        Assert.assertEquals(newMatrix.getAt(1, 2), 22.3333, DELTA);
    }

    @Test
    public static void testMultiplication() {
        Matrix matrixOne = new Matrix(2, 2);
        Matrix matrixTwo = new Matrix(2, 2);

        matrixOne.setAt(0, 0, 1);
        matrixOne.setAt(0, 1, 3);  /* 1 2 */
        matrixOne.setAt(1, 0, 2);  /* 3 4 */
        matrixOne.setAt(1, 1, 4);

        matrixTwo.setAt(0, 0, 5);
        matrixTwo.setAt(0, 1, 7);  /* 5 6 */
        matrixTwo.setAt(1, 0, 6);  /* 7 8 */
        matrixTwo.setAt(1, 1, 8);

        Matrix newMatrix = multiplication(matrixOne, matrixTwo);
        Assert.assertEquals(newMatrix.getAt(0, 0), 19.0);
        Assert.assertEquals(newMatrix.getAt(0, 1), 43.0); /* 19 22 */
        Assert.assertEquals(newMatrix.getAt(1, 0), 22.0); /* 43 50 */
        Assert.assertEquals(newMatrix.getAt(1, 1), 50.0);

        Assert.assertThrows(IncompatibleDimensionsException.class, () -> multiplication(new Matrix(3, 2), new Matrix(3, 2)));
    }

}