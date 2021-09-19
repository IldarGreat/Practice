package ru.ssau.tk.ildar.Practice;

import static org.testng.Assert.*; // Импорт класса Assert
import org.testng.Assert;
import org.testng.annotations.*; // Импорт аннотации Test

public class PersonTest {
    @Test
    public static void testingSettersAndGetters(){
        Person person = new Person(); // Создаем обьект и ссылку
        person.setFirstName("Ildar");
        person.getFirstName();
        person.setLastName("Idiyatov");
        person.getLastName();
        person.setPassportId(9216);
        person.getPassportId();

        // У обьекта Имя - Ildar , Фамилия - Idiyatov , Паспорт - 9216
        Assert.assertEquals(person.getFirstName(), "Ildar");  // Проверка геттеров
        Assert.assertEquals(person.getLastName(), "Idiyatov");  // Все абсолютно правильно
        Assert.assertEquals(person.getPassportId(), 9216);
        person = null; // Зануляем ссылку
    }

    public static void main(String[] args) {  // Запускаю с покрытием кода 33% classes
        PersonTest.testingSettersAndGetters();
    }

}