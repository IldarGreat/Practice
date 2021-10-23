package ru.ssau.tk.ildar.Practice.exceptions;

public class MethodsForExceptions {

    public static void throwVerifiableException() throws MyVerifiableException {
        throw new MyVerifiableException();
    }

    public static void wrapperVerifiableExceptionIntoUnVerifiable() throws MyUnverifiableException {
        try {
            throwVerifiableException();
        } catch (MyVerifiableException verifiableException) {
            throw new MyUnverifiableException(verifiableException);
        }
    }

}
