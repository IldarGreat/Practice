package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTest {
    public static double accuracy=0.00005; // Заданная точность

    @Test
    private static boolean equalsApproximately(double firstNumber,double secondNumber){  // Сравнивает точность чисел
        return Math.abs(firstNumber - secondNumber) < accuracy;  // Возвратит тип boolean
    }

    @Test
    private static boolean equalsApproximately(Point pointOne,Point pointTwo){
        if(Math.abs(pointOne.getX()-pointTwo.getX())>accuracy) return false; // Если разность одних из координат будет больше заданного значения , то вернет false
        if(Math.abs(pointOne.getY()-pointTwo.getY())>accuracy) return false;
        return !(Math.abs(pointOne.getZ() - pointTwo.getZ()) > accuracy);  // И последнее выражение скомкованно
    }

    public static void main(String[] args) {

        Assert.assertTrue(equalsApproximately(1, 1.000001));  // Вернет true , как и ждет метод assertTrue , все ок
        Assert.assertFalse(equalsApproximately(1, 0.5));  // Вернет false , как и ждет метод assertFalse , все ок

        /* Тут словим ошибку , поскольку разность их будет больше чем заданная точка
         Assert.assertTrue(equalsApproximately(1, 1.0001));
          */

        /* Тут словим ошибку , поскольку разность их будет меньше чем заданная точка
         Assert.assertFalse(equalsApproximately(1, 1.00000001));
          */

        Point pointOne=new Point(3,5,7); // Создадим обьекты с нужной точностью точек
        Point pointTwo = new Point(3.0000001,5.000002,7.000004); // Такая же по точности точка
        Assert.assertTrue(equalsApproximately(pointOne,pointTwo)); // Все будет ок
        pointOne=null;pointTwo=null;

        Point pointThree=new Point(3,5,7); // Создадим обьекты с разностью координат болльше чем заданной точности
        Point pointFour = new Point(3.001,5.0002,7.04); // Не такая же по точности точка!
        Assert.assertFalse(equalsApproximately(pointThree,pointFour)); // Все будет ок,поскольку используем assertFalse!
    }
}