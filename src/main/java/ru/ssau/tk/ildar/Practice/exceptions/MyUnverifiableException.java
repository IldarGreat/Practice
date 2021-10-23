package ru.ssau.tk.ildar.Practice.exceptions;

public class MyUnverifiableException extends RuntimeException{

    private static final long serialVersionUID = 3117955450696307098L;

    public MyUnverifiableException(MyVerifiableException exception){
        super(exception);
    }

}
