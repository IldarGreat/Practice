package ru.ssau.tk.ildar.Practice;

public class CloneWithCloneable implements Cloneable{
    private final int number;

    public CloneWithCloneable(int number) {
        this.number = number;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Object) super.clone();
    }
}
