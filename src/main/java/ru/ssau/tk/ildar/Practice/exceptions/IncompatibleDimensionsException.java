package ru.ssau.tk.ildar.Practice.exceptions;

public class IncompatibleDimensionsException extends RuntimeException {

    private static final long serialVersionUID = -957951711289744155L;

    public IncompatibleDimensionsException() {
    }

    public IncompatibleDimensionsException(String string) {
        super(string);
    }
}
