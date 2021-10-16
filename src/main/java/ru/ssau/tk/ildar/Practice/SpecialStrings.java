package ru.ssau.tk.ildar.Practice;

public class SpecialStrings {

    public static void characterByCharacterOutput(String string) {
        for (int element = 0; element < string.length(); element++) {
            System.out.println(string.charAt(element));
        }
    }

    public static void byteArrayOutput(String string) {
        byte[] byteArray = string.getBytes();
        for (byte b : byteArray) {
            System.out.println(b);
        }
    }

    public static boolean isPalindrome(String string) {
        for (int charInString = 0; charInString < string.length() / 2; charInString++) {
            if (string.charAt(charInString) != string.charAt(string.length() - charInString - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDifferentRegister(String stringOne, String stringTwo) {
        if (stringOne == null || stringTwo == null) {
            return false;
        }
        if (stringOne.equalsIgnoreCase(stringTwo)) {
            return !stringOne.equals(stringTwo);
        }
        return false;
    }

    public static int firstOccurrenceOfAString(String stringOne, String stringTwo) {
        return stringOne.indexOf(stringTwo);
    }

    public static int firstOccurrenceOfAStringAfterHalf(String stringOne, String stringTwo) {
        return stringOne.indexOf(stringTwo,stringOne.length()/2);
    }
}
