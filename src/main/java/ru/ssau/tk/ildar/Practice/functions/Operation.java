package ru.ssau.tk.ildar.Practice.functions;

public abstract class Operation {
    protected abstract double apply(double number);

    public double applyTriple(double number) {
        return apply(apply(apply(number)));
    }
}
