package ru.ssau.tk.ildar.Practice.points;

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

    @Test
    public static void testToString() {
        Point point = new Point(3.2,4.2,-1.5);
        Assert.assertEquals(point.toString(),"[3.2,4.2,-1.5]");
    }
}

