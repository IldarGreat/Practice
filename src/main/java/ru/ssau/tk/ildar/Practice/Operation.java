package ru.ssau.tk.ildar.Practice;

public abstract class Operation {
    protected abstract double apply(double number);

    protected double applyTriple(double number) {
        return apply(apply(apply(number)));
    }
}
