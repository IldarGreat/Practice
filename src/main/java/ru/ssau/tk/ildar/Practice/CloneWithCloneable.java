package ru.ssau.tk.ildar.Practice;

public class CloneWithCloneable implements Cloneable {
    public final int number;

    public CloneWithCloneable(int number) {
        this.number = number;
    }

    @Override
    public CloneWithCloneable clone() throws CloneNotSupportedException {
        return (CloneWithCloneable) super.clone();
    }
}
