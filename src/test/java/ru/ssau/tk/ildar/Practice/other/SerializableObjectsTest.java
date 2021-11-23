package ru.ssau.tk.ildar.Practice.other;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;

import static ru.ssau.tk.ildar.Practice.other.SerializableObjects.serializableObject;


public class SerializableObjectsTest {

    @Test
    public static void testSerializablePerson() {
        try {
            serializableObject(new ByteArrayOutputStream(), new Person());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertThrows(FileNotFoundException.class, () -> serializableObject(new FileOutputStream(""), new Person()));
    }

    @Test
    public static void testSerializableObject() {
        Assert.assertThrows(NotSerializableException.class, () -> serializableObject(new ByteArrayOutputStream(), new Object()));
        Assert.assertThrows(FileNotFoundException.class, () -> serializableObject(new FileOutputStream(""), new Object()));
    }
}