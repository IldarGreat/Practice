package ru.ssau.tk.ildar.Practice.other;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

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

    public static String concatenationIntoOneLine(String[] strings) {
        return String.join(",", strings);
    }

    public static String specialModification(String string){
        StringBuilder stringBuilder = new StringBuilder(string);
        for(int element = 0; element<stringBuilder.length(); element++){
            if(element%2==0){
                stringBuilder.replace(element,element+1, Integer.toString(element));
            }
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static String writeDownTheNumbers(int number){
        if(number<0){
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int element=0;element<number;element++){
            stringBuilder.append(element);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public static String changeEncoding(String string, Charset encodingOne,Charset encodingTwo){
        return new String(string.getBytes(encodingOne),encodingTwo);
    }

    public static String[] returnChars(String[] arrayString,int index){
        String[] result = new String[arrayString.length];
        for(int element=0;element<arrayString.length;element++){
            result[element]= arrayString[element].charAt(index)+"";
        }
        return result;
    }

    public static char charInStringArray(String[] strings,int string,int index){
        return strings[string].charAt(index);
    }

    public static int stringsDivideIntoInt(String numberOne,String numberTwo){
        return Integer.parseInt(numberOne)/Integer.parseInt(numberTwo);
    }

    public static void main(String[] args) {
        System.out.println(changeEncoding("Hi,there!", StandardCharsets.UTF_8,StandardCharsets.UTF_16));
    }


}
