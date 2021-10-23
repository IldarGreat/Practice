package ru.ssau.tk.ildar.Practice.exceptions;

import org.testng.annotations.Test;

import static ru.ssau.tk.ildar.Practice.exceptions.MethodsForExceptions.wrapperVerifiableExceptionIntoUnVerifiable;


public class MethodsForExceptionsTest {

    @Test
    public static void testWrapperVerifiableExceptionIntoUnVerifiable() throws MyUnverifiableException {
        try {
            wrapperVerifiableExceptionIntoUnVerifiable();
        } catch (MyUnverifiableException exception) {
            System.out.println("Cause of Exception: " + exception.getCause());
        }
    }

}