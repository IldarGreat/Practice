package ru.ssau.tk.ildar.Practice;
import ru.ssau.tk.ildar.Practice.Point;
class Main{

    public static void main(String[] args) {
        Point pointOne = new Point(1,4,5); // Создание обьекта
        Point pointTwo = new Point(4,1,8); // Создание обьекта
        Point pointThree ; // Создание ссылки

        pointThree = Point.sum(pointOne,pointTwo); // Проверяем метод sum()
        pointThree.getInformation(); System.out.println();

        pointThree = Point.subtract(pointOne,pointTwo); // Проверяем метод subtract()
        pointThree.getInformation(); System.out.println();

        pointThree = Point.multiply(pointOne,pointTwo); // Проверяем метод multiply()
        pointThree.getInformation(); System.out.println();

        pointThree = Point.divide(pointOne,pointTwo); // Проверяем метод sum()
        pointThree.getInformation(); System.out.println();

        pointThree = Point.enlarge(pointThree,4); // Проверяем метод enlarge()
        pointThree.getInformation(); System.out.println();

        System.out.println("Length radius vector of the point:"+pointThree.length()); // Проверка нестатического метода length()
        System.out.println("Length radius vector of the point:"+Point.length(pointThree)); // Проверка статического! метода length()

        pointThree=Point.opposite(pointThree);  // Проверяем метод opposite()
        pointThree.getInformation(); System.out.println();

        pointThree=Point.inverse(pointThree);  // Проверяем метод inverse()
        pointThree.getInformation(); System.out.println();

        pointThree = Point.scalarProduct(pointOne,pointTwo); // Проверка скалярного произведения
        pointThree.getInformation(); System.out.println();

        pointThree = Point.vectorProduct(pointOne,pointTwo); // Проверка векторного произведения
        pointThree.getInformation(); System.out.println();


    }
}
