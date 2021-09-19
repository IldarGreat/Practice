package ru.ssau.tk.ildar.Practice;

import org.testng.Assert;
import org.testng.annotations.*; // Импорт аннотации Test

public class PersonTest {
    @Test
    public static void testingGetFirstName(String firstName,Person person){  // Тестируем firstName
        Assert.assertEquals(person.getFirstName(),firstName);
    }

    @Test
    public static void testingGetLastName(String lastName,Person person){ // Тестируем lastName
        Assert.assertEquals(person.getLastName(),lastName);
    }

    @Test
    public static void testingGetPassportId(int passportId,Person person){ // Тестируем passportId
        Assert.assertEquals(person.getPassportId(),passportId);
    }

    @Test
    public static void testingWithoutParameterConstructor(Person person){  // Тестируем конструктор без параметров
        Assert.assertEquals(person.getFirstName(),"Unknown");
        Assert.assertEquals(person.getLastName(),"Unknown");
        Assert.assertEquals(person.getPassportId(),0);
    }

    @Test
    public static void testingOneParameterConstructor(Person person,int passportId){  // Тестируем конструктор с одним передаваемым параметром
        Assert.assertEquals(person.getFirstName(),"Unknown");
        Assert.assertEquals(person.getLastName(),"Unknown");
        Assert.assertEquals(person.getPassportId(),passportId);
    }

    @Test
    public static void testingTwoParameterConstructor(Person person,String firstName,String lastName){  // Тестируем конструктор с двумя передаваемыми параметрами
        Assert.assertEquals(person.getFirstName(),firstName);
        Assert.assertEquals(person.getLastName(),lastName);
        Assert.assertEquals(person.getPassportId(),0);
    }

    @Test
    public static void testingThreeParameterConstructor(Person person,String firstName,String lastName,int passportId){  // Тестируем конструктор с тремя передаваемыми параметрами
        Assert.assertEquals(person.getFirstName(),firstName);
        Assert.assertEquals(person.getLastName(),lastName);
        Assert.assertEquals(person.getPassportId(),passportId);
    }

    public static void main(String[] args) {  // Запускаю с покрытием кода 33% classes
        int passportId = 9216; // Их будем передавать и с ними же сравнивать
        String firstName = "Ildar";
        String lastName = "Idiyatov";
        Person person = new Person();

        PersonTest.testingWithoutParameterConstructor(person); // Тестируем конструктор без параметров
        // тут ошибка , поскольку конструктор уже задает имя PersonTest.testingGetFirstName(null,person);  // Тестируем геттер с передачей null

        person.setFirstName(firstName); // Используем сеттер
        PersonTest.testingGetFirstName(firstName,person); // Тестируем сеттер

        person.setLastName(lastName); // Используем сеттер
        PersonTest.testingGetLastName(lastName,person); // Тестируем сеттер

        person.setPassportId(passportId); // Используем сеттер
        PersonTest.testingGetPassportId(passportId,person); // Тестируем сеттер

    }

}