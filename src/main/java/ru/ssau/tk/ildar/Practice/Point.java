package ru.ssau.tk.ildar.Practice;

public class Point {
   private Point(){}
    public static double sum(double pointOne,double pointTwo){
       return pointOne+pointTwo;
    }
    public static double substract(double pointOne,double pointTwo){
        return pointOne-pointTwo;
    }
    public static double multiply(double pointOne,double pointTwo){
        return pointOne*pointTwo;
    }
    public static double divide(double pointOne,double pointTwo){
        return pointOne/pointTwo;
    }
}
