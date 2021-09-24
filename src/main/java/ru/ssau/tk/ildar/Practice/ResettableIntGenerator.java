package ru.ssau.tk.ildar.Practice;

public class ResettableIntGenerator implements IntGenerator , Resettable{
    protected int number;

    public ResettableIntGenerator(){
        this.number=0;
    }

    @Override
    public int nextInt(){
        return this.number++;
    }

    @Override
    public void reset(){
        this.number=0;
    }
}
