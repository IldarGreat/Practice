package ru.ssau.tk.ildar.Practice;

public abstract class Operation {
    protected abstract double apply(double number);  // Абстрактный метод (переопределяем в каждом классе наследнике

    protected double applyTriple(double number){
        return apply(apply(apply(number)));
    }
}
