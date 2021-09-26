package ru.ssau.tk.ildar.Practice;

public class Wrapper {

    public static void workingWithWrapper(Number wrapper) {
        Number primitive = 83;
        if (wrapper instanceof Double) primitive = (double) 83;
        else if (wrapper instanceof Float) primitive = (float) 83.0;
        else if (wrapper instanceof Long) primitive = (long) 83;
        else if (wrapper instanceof Byte) primitive = (byte) 83;
        System.out.println("The primitive is " + primitive);
        System.out.println("The wrapper " + wrapper.getClass() + " before autoboxing is " + wrapper);
        wrapper = primitive;
        System.out.println("The wrapper " + wrapper.getClass() + " after autoboxing is " + wrapper);
        System.out.println();
    }


    public static void main(String[] args) {
        Integer wrapperInt = 0;
        Double wrapperDouble = 0.0;
        Float wrapperFloat = 0F;
        Long wrapperLong = 0L;
        Byte wrapperByte = 0;
        workingWithWrapper(wrapperInt);
        workingWithWrapper(wrapperDouble);
        workingWithWrapper(wrapperFloat);
        workingWithWrapper(wrapperLong);
        workingWithWrapper(wrapperByte);
        System.out.println();
        Boolean condition;
        condition = true;
        if (condition) {
            System.out.println(condition);
        }
        condition = false;
        if (condition) {
            System.out.println(condition);
        }
        condition = true;
        if (Boolean.TRUE.equals(condition)) {
            System.out.println(condition);
        }
        condition = false;
        if (Boolean.TRUE.equals(condition)) {
            System.out.println(condition);
        }
        condition = null;
        if (Boolean.TRUE.equals(condition)) {
            System.out.println(condition);
        }
    }


}
