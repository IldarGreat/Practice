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
        return stringOne.indexOf(stringTwo, stringOne.length() / 2);
    }

    public static int lastOccurrenceInTheFirstHalfOfTheString(String stringOne, String stringTwo) {
        return stringOne.lastIndexOf(stringTwo, stringOne.length() / 2);
    }

    public static int numberOfDefinedLines(String[] stringArray, String prefixString, String postfixString) {
        int count = 0;
        for (String s : stringArray) {
            if (s.startsWith(prefixString) && s.endsWith(postfixString)) {
                count++;
            }
        }
        return count;
    }

    public static int numberOfDefinedLinesWithoutSpaces(String[] stringArray, String prefixString, String postfixString) {
        int count = 0;
        for (String s : stringArray) {
            if (s.trim().startsWith(prefixString) && s.trim().endsWith(postfixString)) {
                count++;
            }
        }
        return count;
    }

    public static String tripleReplacement(String stringOne, String stringTwo, String stringThree) {
        String result = stringOne;
        int count = 0;
        while (result.contains(stringTwo) && count < 100) {
            result = result.replaceAll(stringTwo, stringThree);
            count++;
        }
        return result;
    }

    public static String mySubstring(String string, int from, int to) {
        if (from < 0) {
            from = 0;
        }
        if (to > string.length()) {
            to = string.length();
        }
        if (to <= from) {
            return "";
        }
        return string.substring(from, to);
    }

    public static String objectDescription(Object object) {
        return "Описание объекта: " + object;
    }

    public static String[] mySplit(String string) {
        String[] arrayString = string.split(" ");
        for (int element = 0; element < arrayString.length; element++) {
            if (arrayString[element].length() == 1) {
                arrayString[element] = arrayString[element].toUpperCase();
            } else {
                arrayString[element] = arrayString[element].substring(0, 1).toUpperCase() + arrayString[element].substring(1);
            }
        }
        return arrayString;
    }

}
