package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTest {
    public static double accuracy = 0.00005;

    @Test
    private static boolean equalsApproximately(double firstNumber, double secondNumber) {
        return Math.abs(firstNumber - secondNumber) < accuracy;
    }

    @Test
    private static boolean equalsApproximately(Point pointOne, Point pointTwo) {
        if (Math.abs(pointOne.getX() - pointTwo.getX()) > accuracy) {
            return false;
        }
        if (Math.abs(pointOne.getY() - pointTwo.getY()) > accuracy) {
            return false;
        }
        return !(Math.abs(pointOne.getZ() - pointTwo.getZ()) > accuracy);
    }

    public static void main(String[] args) {

        Assert.assertTrue(equalsApproximately(1, 1.000001));
        Assert.assertFalse(equalsApproximately(1, 0.5));

        /* Тут словим ошибку , поскольку разность их будет больше чем заданная точка
         Assert.assertTrue(equalsApproximately(1, 1.0001));
         */

        /* Тут словим ошибку , поскольку разность их будет меньше чем заданная точка
         Assert.assertFalse(equalsApproximately(1, 1.00000001));
         */

        Assert.assertTrue(equalsApproximately(new Point(3, 5, 7), new Point(3.0000001, 5.000002, 7.000004)));
        Assert.assertFalse(equalsApproximately(new Point(3, 5, 7), new Point(3.001, 5.0002, 7.04)));
    }
}