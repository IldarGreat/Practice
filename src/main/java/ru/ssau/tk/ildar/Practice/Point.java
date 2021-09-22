package ru.ssau.tk.ildar.Practice;

import java.lang.Math;

public class Point {
    final private double x;
    final private double y;
    final private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public void getInformation() {
        System.out.println("Coordinates:x=" + getX() + ",y=" + getY() + ",z=" + getZ());
        System.out.println("Length radius vector of the point:" + length());
    }

    public static Point sum(Point pointOne, Point pointTwo) {
        return new Point(pointOne.getX() + pointTwo.getX(), pointOne.getY() + pointTwo.getY(), pointOne.getZ() + pointTwo.getZ());
    }

    public static Point subtract(Point pointOne, Point pointTwo) {
        return new Point(pointOne.getX() - pointTwo.getX(), pointOne.getY() - pointTwo.getY(), pointOne.getZ() - pointTwo.getZ());
    }

    public static Point multiply(Point pointOne, Point pointTwo) {
        return new Point(pointOne.getX() * pointTwo.getX(), pointOne.getY() * pointTwo.getY(), pointOne.getZ() * pointTwo.getZ());
    }

    public static Point divide(Point pointOne, Point pointTwo) {
        return new Point(pointOne.getX() / pointTwo.getX(), pointOne.getY() / pointTwo.getY(), pointOne.getZ() / pointTwo.getZ());
    }

    public static Point enlarge(Point point, double number) {
        return new Point(point.getX() * number, point.getY() * number, point.getZ() * number);
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public static double length(Point point) {
        return point.length();
    }

    public static Point opposite(Point point) {
        return new Point(point.getX() * (-1), point.getY() * (-1), point.getZ() * (-1));
    }

    public static Point inverse(Point point) {
        return new Point(1 / point.getX(), 1 / point.getY(), 1 / point.getZ());
    }

    public static Point scalarProduct(Point pointOne, Point pointTwo) {
        return new Point(pointOne.getX() * pointTwo.getX(), pointOne.getY() * pointTwo.getY(), pointOne.getY() * pointTwo.getY());
    }

    public static Point vectorProduct(Point pointOne, Point pointTwo) {
        return new Point(pointOne.getY() * pointTwo.getZ() - pointOne.getZ() * pointTwo.getY(), pointOne.getZ() * pointTwo.getX() - pointOne.getX() * pointTwo.getZ(),
                pointOne.getX() * pointTwo.getY() - pointOne.getY() * pointTwo.getX());
    }
}
