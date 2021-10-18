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
        Assert.assertEquals(SpecialStrings.tripleReplacement("FirstSecondFirstSecondFirst","First",""),"SecondSecond");
        Assert.assertEquals(SpecialStrings.tripleReplacement("I think this person are stupid","stupid","smart"),"I think this person are smart");
    }

    @Test
    public static void testMySubstring(){
        Assert.assertEquals(SpecialStrings.mySubstring("Welcome to the hell",15,19),"hell");
        Assert.assertEquals(SpecialStrings.mySubstring("Its cum zone",-13,7),"Its cum");
    }
}