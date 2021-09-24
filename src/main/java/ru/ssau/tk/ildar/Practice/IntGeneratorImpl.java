package ru.ssau.tk.ildar.Practice;

public class IntGeneratorImpl implements IntGenerator{
    public int number;

    public IntGeneratorImpl(){
        this.number=0;
    }

    @Override
    public int nextInt(){
        return this.number++;
    }
}
