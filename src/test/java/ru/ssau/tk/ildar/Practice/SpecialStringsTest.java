package ru.ssau.tk.ildar.Practice;

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
    public static void showComparisonExample(){
        SpecialStrings.comparisonExample();
    }
}