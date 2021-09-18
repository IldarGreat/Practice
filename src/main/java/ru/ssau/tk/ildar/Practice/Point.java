package ru.ssau.tk.ildar.Practice;

import java.lang.Math;

public class Point {
    final private double x;
    final private double y;
    final private double z;

    public Point() { // Конструктор без параметров
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Point(double x, double y, double z) { // Конструктор с 3-мя параметрами
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX(){ return this.x;} // Получаем координату x
    public double getY(){ return this.y;} // Получаем координату y
    public double getZ(){ return this.z;} // Получаем координату z

    public void getInformation(){  // Выводим информацию об обьекте
        System.out.println("Coordinates:x="+getX()+",y="+getY()+",z="+getZ());
        System.out.println("Length radius vector of the point:"+length());
    }
    public static Point sum(Point pointOne,Point pointTwo){ // Статический метод суммы двух обьектов
        Point pointNew = new Point(pointOne.getX()+pointTwo.getX(),pointOne.getY()+pointTwo.getY(),pointOne.getZ()+pointTwo.getZ());
        return pointNew; // Возвращаем новосозданный обьект
    }

    public static Point subtract(Point pointOne,Point pointTwo){ // Статический метод разности двух обьектов
        Point pointNew = new Point(pointOne.getX()-pointTwo.getX(),pointOne.getY()-pointTwo.getY(),pointOne.getZ()-pointTwo.getZ());
        return pointNew; // Возвращаем новосозданный обьект
    }

    public static Point multiply(Point pointOne,Point pointTwo){ // Статический метод умножения двух обьектов
        Point pointNew = new Point(pointOne.getX()*pointTwo.getX(),pointOne.getY()*pointTwo.getY(),pointOne.getZ()*pointTwo.getZ());
        return pointNew; // Возвращаем новосозданный обьект
    }

    public static Point divide(Point pointOne,Point pointTwo){ // Статический метод деления двух обьектов
        Point pointNew = new Point(pointOne.getX()/pointTwo.getX(),pointOne.getY()/pointTwo.getY(),pointOne.getZ()/pointTwo.getZ());
        return pointNew; // Возвращаем новосозданный обьект
    }

    public static Point enlarge(Point point,double number){  // Умножения вектора на число
        Point pointNew = new Point(point.getX()*number,point.getY()*number,point.getZ()*number);
        return pointNew; // Возвращаем новосозданный обьект
    }

    public double length(){ // Длина радиус вектора точки на плоскости X,Y,Z
        return Math.sqrt(x*x+y*y+z*z); // Статический метод класса Math
    }

    public static double length(Point point){ // Статический! метод
        return point.length(); // Делегирование(перекладываем работу на нестатический метод length() )
    }

    public static Point opposite(Point point){ // Статический метод создания противоположного обьекта
        Point pointNew = new Point(point.getX()*(-1),point.getY()*(-1),point.getZ()*(-1));
        return pointNew;
    }

    public static Point inverse(Point point){ // Статический метод , создающий обьект путем деления 1 на исходный
        Point pointNew = new Point(1/point.getX(),1/point.getY(),1/point.getZ());
        return pointNew;
    }

}
