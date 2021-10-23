package ru.ssau.tk.ildar.Practice;

public class CloneWithoutCloneable {
    public final int number;

    public CloneWithoutCloneable(int number) {
        this.number = number;
    }

    @Override
    public CloneWithoutCloneable clone() throws CloneNotSupportedException {
        return (CloneWithoutCloneable) super.clone();
    }
}
