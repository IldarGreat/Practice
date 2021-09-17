package ru.ssau.tk.ildar.Practice;

public class Point {
    private double point;
   public Point(){
       this.point=3;
   }
    public double enlarge(Point pointOne,double pointTwo){
       return pointOne.getPoint()*pointTwo;
    }
    public double getPoint(){
       return this.point;
    }
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
