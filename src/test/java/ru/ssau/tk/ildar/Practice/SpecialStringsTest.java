package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SpecialStringsTest {

    @Test
    public static void showCharacterByCharacterOutput() {
        SpecialStrings.characterByCharacterOutput("Its just a test");
    }

    @Test
    public static void showByteArrayOutput() {
        SpecialStrings.byteArrayOutput("That latin");
        System.out.println();
        SpecialStrings.byteArrayOutput("That latin и не латинские");
        System.out.println();
        SpecialStrings.byteArrayOutput("А это Русские слова!");
    }

    @Test
    public static void testIsPalindrome() {
        Assert.assertFalse(SpecialStrings.isPalindrome("Its Not"));
        Assert.assertTrue(SpecialStrings.isPalindrome("madam"));
        Assert.assertTrue(SpecialStrings.isPalindrome("level"));
    }

    @Test
    public static void testIsDifferentRegister() {
        Assert.assertFalse(SpecialStrings.isDifferentRegister(null, null));
        Assert.assertFalse(SpecialStrings.isDifferentRegister("string", null));
        Assert.assertFalse(SpecialStrings.isDifferentRegister("string", "string"));
        Assert.assertFalse(SpecialStrings.isDifferentRegister("string", "stringTwo"));
        Assert.assertTrue(SpecialStrings.isDifferentRegister("string", "String"));
        Assert.assertTrue(SpecialStrings.isDifferentRegister("StRiNg", "sTrInG"));
    }

    @Test
    public static void testFirstOccurrenceOfAString() {
        Assert.assertEquals(SpecialStrings.firstOccurrenceOfAString("firsLast", "Last"), 4);
        Assert.assertEquals(SpecialStrings.firstOccurrenceOfAString("firsLastBad", "Bad"), 8);
        Assert.assertEquals(SpecialStrings.firstOccurrenceOfAString("firsLast", "last"), -1);
    }

    @Test
    public static void testFirstOccurrenceOfAStringAfterHalf() {
        Assert.assertEquals(SpecialStrings.firstOccurrenceOfAStringAfterHalf("FirstAndFirst", "First"), 8);
        Assert.assertEquals(SpecialStrings.firstOccurrenceOfAStringAfterHalf("FirstAndSecond", "First"), -1);
    }

    @Test
    public static void testLastOccurrenceInTheFirstHalfOfTheString() {
        Assert.assertEquals(SpecialStrings.lastOccurrenceInTheFirstHalfOfTheString("FirstAndSecond", "First"), 0);
        Assert.assertEquals(SpecialStrings.lastOccurrenceInTheFirstHalfOfTheString("FirstAnd", "Second"), -1);
    }

    @Test
    public static void testNumberOfDefinedLines() {
        Assert.assertEquals(SpecialStrings.numberOfDefinedLines(new String[]{"FirstAndLast"}, "First", "Last"), 1);
        Assert.assertEquals(SpecialStrings.numberOfDefinedLines(new String[]{"  FirstAndLast  "}, "First", "Last"), 0);
        Assert.assertEquals(SpecialStrings.numberOfDefinedLines(new String[]{"FirstAndLast", "FirstAndFuckingLast", "WhatTheFuck"}, "First", "Last"), 2);
    }

    @Test
    public static void testNumberOfDefinedLinesWithoutSpaces() {
        Assert.assertEquals(SpecialStrings.numberOfDefinedLinesWithoutSpaces(new String[]{"  FirstAndLast  "}, "First", "Last"), 1);
        Assert.assertEquals(SpecialStrings.numberOfDefinedLinesWithoutSpaces(new String[]{"  FirstAndRust  "}, "First", "Last"), 0);
    }

    @Test
    public static void testTripleReplacement() {
        Assert.assertEquals(SpecialStrings.tripleReplacement("FirstSecondFirstSecondFirst", "First", ""), "SecondSecond");
        Assert.assertEquals(SpecialStrings.tripleReplacement("I think this person are stupid", "stupid", "smart"), "I think this person are smart");
    }

    @Test
    public static void testMySubstring() {
        Assert.assertEquals(SpecialStrings.mySubstring("Welcome to the hell", 15, 19), "hell");
        Assert.assertEquals(SpecialStrings.mySubstring("Its cum zone", -13, 7), "Its cum");
    }

    @Test
    public static void showObjectDescription() {
        Person person = new Person("Ildar", "King");
        System.out.println(SpecialStrings.objectDescription(person));
        Point point = new Point(1, 2, 3);
        System.out.println(SpecialStrings.objectDescription(point));
        NamedPoint namedPoint = new NamedPoint(1, 2, 3, "Point");
        System.out.println(SpecialStrings.objectDescription(namedPoint));
        Matrix matrix = new Matrix(1, 1);
        matrix.setAt(0, 0, 1);
        System.out.println(SpecialStrings.objectDescription(matrix));
    }

    @Test
    public static void testMySplit() {
        Assert.assertEquals(SpecialStrings.mySplit("Today I think that I am king"), new String[]{"Today", "I", "Think", "That", "I", "Am", "King"});
    }

    @Test
    public static void testConcatenationIntoOneLine() {
        Assert.assertEquals(SpecialStrings.concatenationIntoOneLine(new String[]{"Today", "I", "Think", "That", "I", "Am", "King"}), "Today,I,Think,That,I,Am,King");
    }

    @Test
    public static void testSpecialModification() {
        Assert.assertEquals(SpecialStrings.specialModification("Hi there"), "e6e4t2i0");
    }

    @Test
    public static void testWriteDownTheNumbers(){
        Assert.assertEquals(SpecialStrings.writeDownTheNumbers(5),"0 1 2 3 4");
        Assert.assertNull(SpecialStrings.writeDownTheNumbers(-1));
    }

    @Test
    public static void testReturnChars(){
        Assert.assertEquals(SpecialStrings.returnChars(new String[] {"apple","banana","watermelon"},2),new String[]{"p","n","t"});
        Assert.assertThrows(NullPointerException.class,()->SpecialStrings.returnChars(null,2));
        Assert.assertThrows(NullPointerException.class,()->SpecialStrings.returnChars(new String[] {"apple","banana",null},2));
        Assert.assertThrows(StringIndexOutOfBoundsException.class,()->
        SpecialStrings.returnChars(new String[] {"apple","banana","watermelon"},6));
    }

    @Test
    public static void testCharInStringArray(){
        Assert.assertEquals(SpecialStrings.charInStringArray(new String[] {"One","Two","Three"},1,1),'w');
        Assert.assertThrows(ArrayIndexOutOfBoundsException.class,()->SpecialStrings.charInStringArray(new String[] {"One","Two","Three"},4,1));
        Assert.assertThrows(StringIndexOutOfBoundsException.class,()->SpecialStrings.charInStringArray(new String[] {"One","Two","Three"},1,4));
        Assert.assertThrows(ArrayIndexOutOfBoundsException.class,()->SpecialStrings.charInStringArray(new String[] {"One","Two","Three"},4,4));
    }

    @Test
    public static void testStringsDivideIntoInt(){
        Assert.assertEquals(SpecialStrings.stringsDivideIntoInt("12","6"),2);
        Assert.assertThrows(NumberFormatException.class,()->SpecialStrings.stringsDivideIntoInt("1f2","6"));
        Assert.assertThrows(ArithmeticException.class,()->SpecialStrings.stringsDivideIntoInt("12","0"));
    }
}