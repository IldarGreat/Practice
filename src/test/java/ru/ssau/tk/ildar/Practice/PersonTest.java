package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.*;

import static ru.ssau.tk.ildar.Practice.Gender.*;

public class PersonTest {
    @Test
    public static void testGetFirstName() {
        Person person = new Person();
        person.setFirstName("Ildar");
        Assert.assertEquals(person.getFirstName(), "Ildar");
    }

    @Test
    public static void testGetLastName() {
        Person person = new Person();
        person.setLastName("Idiot");
        Assert.assertEquals(person.getLastName(), "Idiot");
    }

    @Test
    public static void testGetPassportId() {
        Person person = new Person();
        person.setPassportId(1);
        Assert.assertEquals(person.getPassportId(), 1);
    }

    @Test
    public static void testGetGender() {
        Person person = new Person();
        person.setGender(MALE);
        Assert.assertEquals(person.getGender(), MALE);
        person.setGender(FEMALE);
        Assert.assertEquals(person.getGender(), FEMALE);
    }

    @Test
    public static void testWithoutParameterConstructor() {
        Person person = new Person();
        Assert.assertEquals(person.getFirstName(), "Unknown");
        Assert.assertEquals(person.getLastName(), "Unknown");
        Assert.assertEquals(person.getPassportId(), 0);
    }

    @Test
    public static void testOneParameterConstructor() {
        Person person = new Person(1);
        Assert.assertEquals(person.getFirstName(), "Unknown");
        Assert.assertEquals(person.getLastName(), "Unknown");
        Assert.assertEquals(person.getPassportId(), 1);
    }

    @Test
    public static void testTwoParameterConstructor() {
        Person person = new Person("Ildar", "Idiot");
        Assert.assertEquals(person.getFirstName(), "Ildar");
        Assert.assertEquals(person.getLastName(), "Idiot");
        Assert.assertEquals(person.getPassportId(), 0);
    }

    @Test
    public static void testThreeParameterConstructor() {
        Person person = new Person("Ildar", "Idiot", 1);
        Assert.assertEquals(person.getFirstName(), "Ildar");
        Assert.assertEquals(person.getLastName(), "Idiot");
        Assert.assertEquals(person.getPassportId(), 1);
    }

    @Test
    public static void testToString() {
        Person person = new Person("Ildar", "Idiot", 1);
        Assert.assertEquals(person.toString(), "Ildar Idiot");
    }

    @Test
    public static void testStaticToString() {
        Assert.assertEquals(Person.staticToString(new Person("Ildar", "King")), "Ildar King");
        Assert.assertThrows(NullPointerException.class, () -> Person.staticToString(null));

    }


}