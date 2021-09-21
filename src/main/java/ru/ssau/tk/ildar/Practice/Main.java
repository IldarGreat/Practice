package ru.ssau.tk.ildar.Practice;
import ru.ssau.tk.ildar.Practice.Point;
class Main{
    public static final double POSITIVE_INFINITY = 1.0 / 0.0; // Ввожу плюс бесконечность
   public static final double NEGATIVE_INFINITY = -1.0 / 0.0; // Ввожу минус бесконечность

    public static void main(String[] args) {
       double number=35;

       IdenticalOperation checkIdentical = new IdenticalOperation();
       SqrtOperation checkSqrt = new SqrtOperation();
       TangentOperation checkTangent = new TangentOperation();
        System.out.println("The number:"+checkIdentical.apply(number)+" sqrt:"+checkSqrt.apply(number)+" tan:"+ checkTangent.apply(POSITIVE_INFINITY));
        System.out.println("Triple sqrt:"+checkSqrt.applyTriple(number)+" triple tan:"+ checkTangent.applyTriple(number));
    }
}
