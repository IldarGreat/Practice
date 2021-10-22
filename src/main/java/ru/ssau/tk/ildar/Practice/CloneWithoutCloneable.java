package ru.ssau.tk.ildar.Practice;

public class CloneWithoutCloneable {

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Object) super.clone();
    }
}
