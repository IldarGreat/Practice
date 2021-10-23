package ru.ssau.tk.ildar.Practice.points;

public class Points extends Point {
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
