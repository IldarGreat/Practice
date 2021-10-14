package ru.ssau.tk.ildar.Practice;

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
}
