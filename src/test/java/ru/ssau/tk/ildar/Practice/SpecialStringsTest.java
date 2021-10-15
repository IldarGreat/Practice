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
    public static void testIsDifferentRegister(){
        Assert.assertFalse(SpecialStrings.isDifferentRegister(null,null));
        Assert.assertFalse(SpecialStrings.isDifferentRegister("string",null));
        Assert.assertFalse(SpecialStrings.isDifferentRegister("string","string"));
        Assert.assertFalse(SpecialStrings.isDifferentRegister("string","stringTwo"));
        Assert.assertTrue(SpecialStrings.isDifferentRegister("string","String"));
        Assert.assertTrue(SpecialStrings.isDifferentRegister("StRiNg","sTrInG"));
    }
}