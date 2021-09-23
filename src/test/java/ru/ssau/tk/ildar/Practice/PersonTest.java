package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.*;

public class PersonTest {
    @Test
    public static void testGetFirstName(){
        Person person = new Person();
        person.setFirstName("Ildar");
        Assert.assertEquals(person.getFirstName(),"Ildar");
    }

    @Test
    public static void testGetLastName(){
        Person person = new Person();
        person.setLastName("Idiot");
        Assert.assertEquals(person.getLastName(),"Idiot");
    }

    @Test
    public static void testGetPassportId(){
        Person person = new Person();
        person.setPassportId(1);
        Assert.assertEquals(person.getPassportId(),1);
    }

    @Test
    public static void testGetGender(){
        Person person = new Person();
        person.setGender(Person.Gender.MALE);
        Assert.assertEquals(person.getGender(), Person.Gender.MALE);
        person.setGender(Person.Gender.FEMALE);
        Assert.assertEquals(person.getGender(), Person.Gender.FEMALE);
    }

    @Test
    public static void testWithoutParameterConstructor(){
        Person person = new Person();
        Assert.assertEquals(person.getFirstName(),"Unknown");
        Assert.assertEquals(person.getLastName(),"Unknown");
        Assert.assertEquals(person.getPassportId(),0);
    }

    @Test
    public static void testOneParameterConstructor(){
        Person person = new Person(1);
        Assert.assertEquals(person.getFirstName(),"Unknown");
        Assert.assertEquals(person.getLastName(),"Unknown");
        Assert.assertEquals(person.getPassportId(),1);
    }

    @Test
    public static void testTwoParameterConstructor(){
        Person person = new Person("Ildar","Idiot");
        Assert.assertEquals(person.getFirstName(),"Ildar");
        Assert.assertEquals(person.getLastName(),"Idiot");
        Assert.assertEquals(person.getPassportId(),0);
    }

    @Test
    public static void testThreeParameterConstructor(){
        Person person = new Person("Ildar","Idiot",1);
        Assert.assertEquals(person.getFirstName(),"Ildar");
        Assert.assertEquals(person.getLastName(),"Idiot");
        Assert.assertEquals(person.getPassportId(),1);
    }

}